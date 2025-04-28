package lotto

class LottoController {
    fun run() {
        val amount = InputView.readPurchaseAmount()
        val tickets = LottoMachine().generate(amount / 1000)
        OutputView.printTickets(tickets)

        val winningNumbers = InputView.readWinningNumbers()
        val bonusNumber = InputView.readBonusNumber()

        val winningLotto = WinningLotto(winningNumbers, bonusNumber)
        val result = LottoResult(tickets, winningLotto)

        OutputView.printResult(result)
    }
}
