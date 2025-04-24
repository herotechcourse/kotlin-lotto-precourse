package lotto

fun main() {
    val amount = InputView.readPurchaseAmount()
    val count = amount / 1000
    val tickets = LottoMachine.generateTickets(count)

    OutputView.printTickets(tickets)

    val winningNumbers = InputView.readWinningNumbers()
    val bonus = InputView.readBonusNumber(winningNumbers)

    val winningLotto = WinningLotto(winningNumbers, bonus)
    val result = LottoResult.calculate(tickets, winningLotto)

    OutputView.printResult(result)
    OutputView.printReturnRate(result, amount)
}
