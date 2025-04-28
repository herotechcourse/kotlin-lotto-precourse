package lotto

import lotto.domain.Lotto
import lotto.domain.LottoFactory
import lotto.view.InputView

fun main() {
    // Entry point that orchestrates the whole flow:
    // [x] InputView gets input
    // [x] LottoGenerator creates tickets
    // [ ] ResultChecker calculates result
    // [ ] OutputView prints tickets
    // [ ] OutputView prints statistics

    val purchaseAmount =  InputView.readPurchaseAmount()
    val ticketAmount = purchaseAmount.div(1000)

    val lottoTickets = LottoFactory.createLottos(ticketAmount)
    println("Generated Lotto Tickets")
    for (lottoTicket in lottoTickets) {
        println(lottoTicket.getNumbers())
    }

    val winningNumbers = InputView.readWinningNumbers()
    val bonusNumber = InputView.readBonusNumber(winningNumbers)

    println("Matching Results")
    for (ticket in lottoTickets) {
        val matchCount = ticket.countMatchingNumbers(winningNumbers)
        val bonusMatch = ticket.contains(bonusNumber)

        println("Ticket: ${ticket.getNumbers()}, Match: $matchCount numbers, Bonus Match: $bonusMatch")
    }
}
