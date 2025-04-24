package lotto

fun main() {
    try {
        val money = InputView.readPurchaseAmount()
        val tickets = LottoMachine.createLottos(money)
        OutputView.printLottos(tickets)

        val winNums = InputView.readWinningNumbers()
        val bonus = InputView.readBonusNumber()
        val winningLotto = WinningLotto(winNums, bonus)

        val result = LottoResult(winningLotto, tickets)
        OutputView.printResult(result)
    } catch (e: IllegalArgumentException) {
        println(e.message)
    }
}