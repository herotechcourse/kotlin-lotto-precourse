package lotto.presentation

import lotto.Lotto
import lotto.Rank
import java.util.*

interface OutputView {
    fun printBlankLine()
    fun printInputPrompt(promptMessage: String)
    fun printErrorMessage(errorMessage: String?)
    fun printNumberOfTickets(numberOfTickets: Int)
    fun printTickets(tickets: List<Lotto>)
    fun printStatistics(statistics: Map<Rank, Int>)
    fun printProfitRate(profitRate: Double)
}

class OutputViewImpl : OutputView {

    override fun printBlankLine() {
        println()
    }

    override fun printInputPrompt(promptMessage: String) {
        println(promptMessage)
    }

    override fun printErrorMessage(errorMessage: String?) {
        println("$ERROR_MESSAGE_PREFIX $errorMessage")
    }

    override fun printNumberOfTickets(numberOfTickets: Int) {
        println()
        println(NUMBER_OF_TICKETS_MESSAGE.format(numberOfTickets))
    }

    override fun printTickets(tickets: List<Lotto>) {
        tickets.forEach { ticket ->
            println(ticket)
        }
        println()
    }

    override fun printStatistics(statistics: Map<Rank, Int>) {
        println()
        println(WINNING_STATISTICS)
        println(DIVIDER)
        println(FIFTH_RANK_MESSAGE.format(statistics[Rank.FIFTH] ?: 0))
        println(FOURTH_RANK_MESSAGE.format(statistics[Rank.FOURTH] ?: 0))
        println(THIRD_RANK_MESSAGE.format(statistics[Rank.THIRD] ?: 0))
        println(SECOND_RANK_MESSAGE.format(statistics[Rank.SECOND] ?: 0))
        println(FIRST_RANK_MESSAGE.format(statistics[Rank.FIRST] ?: 0))
    }

    override fun printProfitRate(profitRate: Double) {
        println("$PROFIT_RATE ${String.format(Locale.US, "%.1f", profitRate)}%.")
    }

    companion object {
        private const val ERROR_MESSAGE_PREFIX = "[ERROR]"
        private const val NUMBER_OF_TICKETS_MESSAGE = "You have purchased %d tickets."
        private const val WINNING_STATISTICS = "Winning Statistics"
        private const val DIVIDER = "---"
        private const val FIFTH_RANK_MESSAGE = "3 Matches (5,000 KRW) – %d tickets"
        private const val FOURTH_RANK_MESSAGE = "4 Matches (50,000 KRW) – %d tickets"
        private const val THIRD_RANK_MESSAGE = "5 Matches (1,500,000 KRW) – %d tickets"
        private const val SECOND_RANK_MESSAGE = "5 Matches + Bonus Ball (30,000,000 KRW) – %d tickets"
        private const val FIRST_RANK_MESSAGE = "6 Matches (2,000,000,000 KRW) – %d tickets"
        private const val PROFIT_RATE = "Total return rate is"
    }
}