package lotto.io

import lotto.Lotto
import lotto.LottoRanks
import lotto.LottoResults
import java.util.Locale

object OutputView {
    fun showTickets(tickets: MutableList<Lotto>) {
        println("You have purchased ${tickets.size} tickets.")
        for (ticket in tickets) {
            println(ticket.getNumbers())
        }
    }

    fun showStatistics(lottoResults: LottoResults) {
        println("Winning Statistics")
        println("---")
        println(
            "3 Matches (5,000 KRW) – ${lottoResults.getMatchResult(LottoRanks.MATCH_3)} tickets\n" + "4 Matches (50,000 KRW) – ${
                lottoResults.getMatchResult(
                    LottoRanks.MATCH_4
                )
            } tickets\n" + "5 Matches (1,500,000 KRW) – ${lottoResults.getMatchResult(LottoRanks.MATCH_5)} tickets\n" + "5 Matches + Bonus Ball (30,000,000 KRW) – ${
                lottoResults.getMatchResult(
                    LottoRanks.MATCH_5_AND_BONUS
                )
            } tickets\n" + "6 Matches (2,000,000,000 KRW) – ${lottoResults.getMatchResult(LottoRanks.MATCH_6)} tickets"
        )
    }

    fun showTotalRate(number: Double) {
        val formattedNumber = if (number % 1 == 0.0) {
            number.toInt().toString()
        } else {
            "%.1f".format(Locale.US, number)
        }

        println("Total return rate is ${formattedNumber}%. ")
    }
}
