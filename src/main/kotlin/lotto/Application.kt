package lotto

fun main() {
    try {
        val inputView = InputView().readAmount()

        val count = inputView / 1000
        val outputView = OutputView()
        val lottos = LottoMachine().createTickets(count)

        outputView.printResult(lottos)

        val winningNum = InputView().readWinningNumbers()
        val bonusNum = InputView().readBonusNumber()

        val result = LottoResult().calculateStatics(winningNum, bonusNum, lottos)
        val total = LottoResult().calculateTotal(result, inputView)

        outputView.printStatics(result, total)
    } catch (e: IllegalArgumentException) {
        println(e.message)
    }
}
