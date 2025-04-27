package lotto

fun main() {
    val amount = InputView.readPurchaseAmount()
    val ticketCount = amount / 1000
    val tickets = LottoService.generateTickets(ticketCount)

    OutputView.printTickets(tickets)

    val numbers = InputView.readWinningNumbers()
    val bonus = InputView.readBonusNumber()

    val result = LottoService.calculateLottoResult(tickets, numbers, bonus)

    OutputView.printResult(result)
}
