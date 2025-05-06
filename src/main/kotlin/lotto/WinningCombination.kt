package lotto

class WinningCombination(
    private val winningNumbers: List<Int>,
    private val bonusBall: Int,
    private var totalPrize: Int
) {
    val winningNumberList: List<Int> get() = winningNumbers

    fun getTotalPrize(): Int {
        return totalPrize
    }

    fun match(lottoTickets: List<Lotto>): MutableMap<Prize, Int> {
        val prizeCountList = initializePrizeCount()

        lottoTickets.forEach { lotto ->
            countPrize(lotto, prizeCountList)
        }

        totalPrize = calculateTotalPrizeMoney(prizeCountList)

        return prizeCountList
    }

    private fun initializePrizeCount(): MutableMap<Prize, Int> = mutableMapOf(
        Prize.FIFTH to 0,
        Prize.FOURTH to 0,
        Prize.THIRD to 0,
        Prize.SECOND to 0,
        Prize.FIRST to 0
    )

    private fun countPrize(lotto: Lotto, prizeList: MutableMap<Prize, Int>) {
        val matchedCount = winningNumbers.count { it in lotto.numberList }

        when (matchedCount) {
            6 -> prizeList[Prize.FIRST] = prizeList[Prize.FIRST]!! + 1
            5 -> {
                if (lotto.numberList.contains(bonusBall)) {
                    prizeList[Prize.SECOND] = prizeList[Prize.SECOND]!! + 1
                } else {
                    prizeList[Prize.THIRD] = prizeList[Prize.THIRD]!! + 1
                }
            }

            4 -> prizeList[Prize.FOURTH] = prizeList[Prize.FOURTH]!! + 1
            3 -> prizeList[Prize.FIFTH] = prizeList[Prize.FIFTH]!! + 1
        }
    }

    private fun calculateTotalPrizeMoney(prizeCount: MutableMap<Prize, Int>) =
        prizeCount.entries.sumOf { it.value * it.key.money }
}