package lotto

fun main() {
    val amount = InputView.getUserPurchaseAmount()

    val numberOfTickets = amount / const.TICKET_PRICE
    val tickets = LottoTickets.generate(numberOfTickets)
    OutputView.printTickets(tickets)

    val winningNumbers = InputView.getUserWinningNumbers()
    val bonusNumbers = InputView.getUserBonusNumbers(winningNumbers)
    OutputView.printStatistics(tickets, winningNumbers, bonusNumbers)
}
