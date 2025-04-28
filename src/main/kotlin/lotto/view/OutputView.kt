package lotto.view

import lotto.support.Message
import lotto.Lotto
import lotto.domain.PrizeResult
import lotto.domain.Rank

object OutputView {

    fun printPurchaseAmountPrompt() {
        println(Message.PURCHASE_AMOUNT_PROMPT)
    }

    fun printTickets(tickets: List<Lotto>){
        println()
        println(Message.PURCHASED_TICKETS_MESSAGE.format(tickets.size))
        for (ticket in tickets) {
            println(ticket)
        }
    }

    fun printWinningTicketPrompt(){
        println()
        println(Message.WINNING_TICKET_PROMPT)
    }

    fun printBonusNumberPrompt(){
        println()
        println(Message.BONUS_NUMBER_PROMPT)
    }

    fun printErrorMessage(message: String?) {
        println(message ?: Message.UNKNOWN_ERROR)
    }

    fun printResultTitle(){
        println(Message.RESULT_TITLE)
        println(Message.DRAW_LINE)
    }

    private fun printRankLine(rank: Rank, prizeResult: PrizeResult) {
        if (rank.needsBonus) {
            println(Message.BONUS_MATCH_RESULT_FORMAT.format(rank.matchCount, String.format("%,d", rank.prize),
                prizeResult.getRankCount(rank)))
            return
        }
        println(Message.NORMAL_MATCH_RESULT_FORMAT.format(rank.matchCount, String.format("%,d", rank.prize),
            prizeResult.getRankCount(rank)))
    }

    fun printPrizeResult(prizeResult: PrizeResult) {
        printResultTitle()
        for (rank in Rank.entries.sortedBy { it.ordinal }) {
            if (rank == Rank.NONE) continue
            printRankLine(rank, prizeResult)
        }
    }

    fun printProfit(profit: String){
        println(Message.RETURN_RATE_MESSAGE.format(profit))
    }
}