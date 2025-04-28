package lotto.controller

import lotto.service.LottoService
import lotto.view.InputView
import lotto.view.OutputView

class LottoController {

    fun run() {
        val purchaseAmount = InputView.readPurchaseAmount()
        val lottoTickets = LottoService.purchaseTickets(purchaseAmount)
        OutputView.printTickets(lottoTickets.getTickets())

        val winningNumbers = InputView.readWinningNumbers()
        val bonusNumber = InputView.readBonusNumber()

        val result = LottoService.calculateResult(lottoTickets, winningNumbers, bonusNumber)
        OutputView.printResult(result, lottoTickets.getTickets().size)
    }
}