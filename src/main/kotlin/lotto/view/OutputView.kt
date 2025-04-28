package lotto.view

import lotto.Lotto
import lotto.domain.Rank
import java.util.Locale

class OutputView {

    fun displayError(message: String?) {
        println(message)
    }

    fun displayPurchaseCount(count: Int) {
        println("\nYou have purchased $count tickets.")
    }

    fun displayLottoTickets(tickets: List<Lotto>) {
        tickets.forEach { ticket ->
            println(ticket.getNumbers()) //.sorted() at the end
        }
    }

    fun displayMatchResults(results: Map<Rank, Int>) {
        println("\nWinning Statistics\n---")
        val displayRanks = listOf(Rank.FIFTH, Rank.FOURTH, Rank.THIRD, Rank.SECOND, Rank.FIRST)
        displayRanks.forEach { rank ->
            val count = results[rank] ?: 0
            val message = when (rank) {
                Rank.SECOND -> "5 Matches + Bonus Ball (${rank.prize.withComma()} KRW) – $count tickets"
                Rank.THIRD -> "5 Matches (${rank.prize.withComma()} KRW) – $count tickets"
                Rank.FOURTH -> "4 Matches (${rank.prize.withComma()} KRW) – $count tickets"
                Rank.FIFTH -> "3 Matches (${rank.prize.withComma()} KRW) – $count tickets"
                Rank.FIRST -> "6 Matches (${rank.prize.withComma()} KRW) – $count tickets"
                else -> ""
            }
            println(message)
        }
    }

    private fun Long.withComma(): String = String.format(Locale.US, "%,d", this)

    fun displayRate(profitRate: Double) {
        val formattedRate = String.format(Locale.US, "%.1f", profitRate)
        println("Total return rate is ${formattedRate}%.")
    }

}