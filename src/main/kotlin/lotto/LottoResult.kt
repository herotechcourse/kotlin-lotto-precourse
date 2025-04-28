package lotto

class LottoResult(
    val match3: Int,
    val match4: Int,
    val match5: Int,
    val match5WithBonus: Int,
    val match6: Int,
    val returnRate: Double
) {

    companion object {

        private const val PRIZE_3 = 5_000
        private const val PRIZE_4 = 50_000
        private const val PRIZE_5 = 1_500_000
        private const val PRIZE_5_BONUS = 30_000_000
        private const val PRIZE_6 = 2_000_000_000

        fun calculate(tickets: LottoTickets, winningNumbers: List<Int>, bonusNumber: Int): LottoResult {
            val win = WinningNumbers(winningNumbers, bonusNumber)

            var match3 = 0
            var match4 = 0
            var match5 = 0
            var match5WithBonus = 0
            var match6 = 0

            tickets.tickets.forEach { ticket ->
                val match = win.match(ticket)
                when (match.matchCount) {
                    3 -> match3++
                    4 -> match4++
                    5 -> if (match.hasBonus) match5WithBonus++ else match5++
                    6 -> match6++
                }
            }

            val totalPrize = (match3 * PRIZE_3) +
                    (match4 * PRIZE_4) +
                    (match5 * PRIZE_5) +
                    (match5WithBonus * PRIZE_5_BONUS) +
                    (match6 * PRIZE_6)

            val totalSpent = tickets.tickets.size * 1000

            return LottoResult(
                match3, match4, match5, match5WithBonus, match6,
                totalPrize.toDouble() / totalSpent * 100
            )
        }
    }
}
