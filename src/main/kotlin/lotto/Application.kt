package lotto

import camp.nextstep.edu.missionutils.Console

fun main() {
    // TODO: Implement the program
    val amountPurchase = InputView.getPurchaseAmount()
    val tickets = LottoEngine.buyTickets(amountPurchase)

    OutputView.displayLottoTickets(tickets)

    val winningNumbers = InputView.getWinningNumbers()
    val bonusNumber = InputView.getBonusNumber(winningNumbers)

    val results = LottoEngine.evaluateTicketResults(tickets, winningNumbers, bonusNumber)
    val totalWinnings = LottoEngine.totalResultWinnings(results)

    OutputView.displayLottoResults(results, amountPurchase, totalWinnings)

}
