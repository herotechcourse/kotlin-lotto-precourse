package lotto

class LottoResult(private val tickets: List<Lotto>, private val winningNumbers: List<Int>, private val bonusNumber: Int) {

    fun getPrizeStatistics(): Map<String, Int> {
        val resultStats = mutableMapOf(
            "3 Matches (5,000 KRW)" to 0,
            "4 Matches (50,000 KRW)" to 0,
            "5 Matches (1,500,000 KRW)" to 0,
            "5 Matches + Bonus Ball (30,000,000 KRW)" to 0,
            "6 Matches (2,000,000,000 KRW)" to 0
        )

        tickets.forEach { ticket ->
            val matches = ticket.getNumbers().intersect(winningNumbers).size
            val bonusMatch = if (ticket.getNumbers().contains(bonusNumber)) 1 else 0

            when (matches) {
                6 -> resultStats["6 Matches (2,000,000,000 KRW)"] = resultStats.getValue("6 Matches (2,000,000,000 KRW)") + 1
                5 -> if (bonusMatch == 1) {
                    resultStats["5 Matches + Bonus Ball (30,000,000 KRW)"] =
                        resultStats.getValue("5 Matches + Bonus Ball (30,000,000 KRW)") + 1
                } else {
                    resultStats["5 Matches (1,500,000 KRW)"] = resultStats.getValue("5 Matches (1,500,000 KRW)") + 1
                }
                4 -> resultStats["4 Matches (50,000 KRW)"] = resultStats.getValue("4 Matches (50,000 KRW)") + 1
                3 -> resultStats["3 Matches (5,000 KRW)"] = resultStats.getValue("3 Matches (5,000 KRW)") + 1
            }
        }
        return resultStats
    }

    fun calculateProfitRate(totalAmount: Int): Double {
        val totalWinnings = tickets.sumBy { ticket ->
            val matches = ticket.getNumbers().intersect(winningNumbers).size
            val bonusMatch = if (ticket.getNumbers().contains(bonusNumber)) 1 else 0
            when (matches) {
                6 -> 2_000_000_000
                5 -> if (bonusMatch == 1) 30_000_000 else 1_500_000
                4 -> 50_000
                3 -> 5_000
                else -> 0
            }
        }
        return (totalWinnings / totalAmount.toDouble()) * 100
    }
}
