package lotto.view

import lotto.model.LottoManager
import lotto.model.User

class OutputView {
    fun printPurchasedTickets(user: User) {
        user.lottoTickets.forEach { ticket ->
            println(ticket.numbers)
        }
    }

    fun printWinningStatistics(lottoManager: LottoManager) {
        val winningStatistics = """
            Winning Statistics
            ---
            3 Matches (5,000 KRW) – ${lottoManager.matchedLottoTicket[5]} tickets
            4 Matches (50,000 KRW) –  ${lottoManager.matchedLottoTicket[4]} tickets
            5 Matches (1,500,000 KRW) –  ${lottoManager.matchedLottoTicket[3]} tickets
            5 Matches + Bonus Ball (30,000,000 KRW) – ${lottoManager.matchedLottoTicket[2]} tickets
            6 Matches (2,000,000,000 KRW) – ${lottoManager.matchedLottoTicket[1]} tickets
            Total return rate is ${lottoManager.winningRate}%.
        """.trimIndent()
        println(winningStatistics)
    }

    fun printNewLine() {
        println()
    }
}