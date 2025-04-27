package lotto

import camp.nextstep.edu.missionutils.Randoms

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] Lotto must contain exactly 6 numbers." }
        require(numbers.toSet().size == numbers.size) { "[ERROR] Lotto must not contain duplicated numbers" }
        require(numbers.all { it in 1..45 }) { "[ERROR] Lotto Lotto number must between 1 to 45" }
    }

    // find matches and determine the prize rank
    fun findPrizeRank(winningNumbers: List<Int>, bonusNumber: Int): Prize {
        val sameNumberCount = numbers.intersect(winningNumbers.toSet()).size
        return when (sameNumberCount) {
            6 -> Prize.First
            5 -> if (numbers.contains(bonusNumber)) Prize.Second else Prize.Third
            4 -> Prize.Fourth
            3 -> Prize.Fifth
            else -> Prize.None
        }
    }

    companion object {
        fun calculatePrintPrize(prizeRankList: List<Prize>, purchaseAmount: Int) {
            val totalPrizeMoney = prizeRankList.sumOf { it.money }
            val rate: Double = totalPrizeMoney.toDouble().div(purchaseAmount.toDouble())
            var rawPrizeMap: Map<Prize, Int> = initPrizeMap(prizeRankList)
            val prizeMap = rawPrizeMap.filterKeys { it != Prize.None }.toSortedMap()
            OutputView.printPrize(rate, prizeMap)
        }

        private fun initPrizeMap(prizeRankList: List<Prize>): Map<Prize, Int> =
            Prize.entries.associateWith { prize -> prizeRankList.count { it == prize } }

        fun generateTickets(purchaseAmount: Int): List<List<Int>> {
            var numberOfTickets = purchaseAmount / 1000
            val rawTickets: MutableList<MutableList<Int>> = mutableListOf()
            for (i in 0 until numberOfTickets) {
                val singleTicket = generateSingleTicket()
                rawTickets.add(singleTicket)
            }
            return InputValidate.validateTickets(rawTickets)
        }

        private fun generateSingleTicket(): MutableList<Int> = Randoms.pickUniqueNumbersInRange(1, 45, 6)

    }

}
