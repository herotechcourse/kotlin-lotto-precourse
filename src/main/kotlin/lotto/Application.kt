package lotto

import camp.nextstep.edu.missionutils.Console

fun main() {
    Application().run()
}

class Application {
    fun run() {
        val purchaseAmount = InputView.readPurchaseAmount()
        val lottoTickets = LottoMachine.issueTickets(purchaseAmount)

        OutputView.printLottoTickets(lottoTickets)

        val winningNumbers = InputView.readWinningNumbers()
        val bonusNumber = InputView.readBonusNumber()

        val winningLotto = WinningLotto(winningNumbers, bonusNumber)
        val lottoResult = LottoResult.calculate(lottoTickets, winningLotto)

        OutputView.printStatistics(lottoResult)
    }
}
