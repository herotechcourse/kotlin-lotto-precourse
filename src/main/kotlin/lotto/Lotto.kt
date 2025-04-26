package lotto

import camp.nextstep.edu.missionutils.Randoms

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] Lotto must contain exactly 6 numbers." }
        require(numbers.toSet().size == numbers.size) { "[ERROR] Lotto must not contain duplicated numbers" }
    }

    // find matches and determine the prize rank
    fun findMatches(winningNumbers: List<Int>, bonusNumber: Int): Prize {
        val sameNumberCount = numbers.intersect(winningNumbers.toSet()).size
        return when (sameNumberCount) {
            6 -> Prize.FirstPrize
            5 -> if (numbers.contains(bonusNumber)) Prize.SecondPrize else Prize.ThirdPrize
            4 -> Prize.FourthPrize
            3 -> Prize.FifthPrize
            else -> Prize.None
        }
    }

    companion object {
        fun calculatePrintPrize(prizeRankList: List<Prize>, prize: Int, purchaseAmount: Int) {
            var rate: Double = prize.toDouble().div(purchaseAmount.toDouble()) * 100
            var rawPrizeMap: Map<Prize, Int> = initPrizeMap(prizeRankList)
            val prizeMap = rawPrizeMap.filterKeys { it != Prize.None }.toSortedMap()
            OutputView.printPrize(rate, prizeMap)
        }

        private fun initPrizeMap(prizeRankList: List<Prize>): Map<Prize, Int> {
            val prizeMap = Prize.values().associateWith { prize ->
                prizeRankList.count { it == prize }
            }
            return prizeMap
        }

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
