package lotto

import lotto.domain.WinningNumbers
import lotto.service.LottoService
import lotto.view.InputView
import lotto.view.OutputView

class LottoApplication {
    private val lottoService = LottoService()

    fun run() {
        val amount = readValidPurchaseAmount()
        val lottos = lottoService.purchaseLottos(amount)

        OutputView.printLottos(lottos)
        println()

        val winningNumbers = readValidWinningNumbers()
        val results = lottoService.calculateResults(lottos, winningNumbers)

        OutputView.printWinningStatistics(results, amount)
        println()
    }

    private fun readValidPurchaseAmount(): Int {
        while (true) {
            try {
                return InputView.readPurchaseAmount()
            } catch (e: java.lang.IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    private fun readValidWinningNumbers(): WinningNumbers {
        while (true) {
            try {
                val numbers = InputView.readWinningNumbers()
                val bonusNumber = InputView.readBonusNumber()
                return WinningNumbers(numbers, bonusNumber)
            } catch (e: java.lang.IllegalArgumentException) {
                println(e.message)
            }
        }
    }
}