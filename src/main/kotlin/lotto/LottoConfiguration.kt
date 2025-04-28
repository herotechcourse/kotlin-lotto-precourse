package lotto


enum class WinningCases {
    WITHOUT_BONUS_BALL, WITH_AND_WITHOUT_BONUS_BALL
}

class LottoConfiguration {
    companion object {
        const val NUMBER_AMOUNT = 6

        const val TICKET_PRICE = 1000
        private const val CURRENCY = "KRW"

        val WINNING_SUM_DICTIONARY = mapOf(
            3 to 5000,
            4 to 50000,
            5 to 1500000,
            6 to 2000000000,
        )

        val WINNING_SUM_WITH_BONUS_BALL_DICTIONARY = mapOf(
            5 to 30000000,
        )

        private val WINNING_CASES_USE_BONUS_BALL = mapOf(
            3 to WinningCases.WITHOUT_BONUS_BALL,
            4 to WinningCases.WITHOUT_BONUS_BALL,
            5 to WinningCases.WITH_AND_WITHOUT_BONUS_BALL,
            6 to WinningCases.WITHOUT_BONUS_BALL,
        )

        fun getSumForEachMatch(matches: Int, tickets: List<Int>): Int {
            if (matches !in WINNING_CASES_USE_BONUS_BALL)
                return 0
            val winningSum = WINNING_SUM_DICTIONARY[matches]!!
            val winningWithBonusSum: Int =
                if (WINNING_CASES_USE_BONUS_BALL[matches] == WinningCases.WITHOUT_BONUS_BALL) winningSum
                else WINNING_SUM_WITH_BONUS_BALL_DICTIONARY[matches]!!
            return tickets.filter { it == 1 }.size * winningWithBonusSum + tickets.filter { it == 0 }.size * winningSum
        }

        fun getTicketInfoFormat(numbers: List<Int>): String {
            val ticketInfoMessage = "[${numbers.joinToString(", ")}]"
            return ticketInfoMessage
        }

        private fun getFormatedSum(sum: Int): String {
            return sum.toString().reversed().chunked(3).joinToString(",").reversed()
        }

        fun printWinningStatisticsRow(matchesAmount: Int, isUsedBonusBall: Boolean, ticketsAmount: Int) {
            val winningSum = if (isUsedBonusBall) WINNING_SUM_WITH_BONUS_BALL_DICTIONARY[matchesAmount]
            else WINNING_SUM_DICTIONARY[matchesAmount]
            val bonusInfo = if (isUsedBonusBall) "+ Bonus Ball " else ""
            if (winningSum == null)
                return
            val winningStatisticRow =
                "$matchesAmount Matches $bonusInfo(${getFormatedSum(winningSum)} $CURRENCY) – $ticketsAmount tickets"
            println(winningStatisticRow)
        }
    }
}