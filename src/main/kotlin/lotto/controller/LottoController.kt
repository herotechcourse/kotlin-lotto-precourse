package lotto.controller

import lotto.service.LottoService
import lotto.service.LottoServiceImpl
import lotto.view.InputView
import lotto.view.OutputView

class LottoController(
    private val lottoService: LottoService = LottoServiceImpl()
) {

    fun run() {
        val purchaseAmount = InputView.readPurchaseAmount()
        val lottoTickets = lottoService.purchaseTickets(purchaseAmount)
        OutputView.printTickets(lottoTickets.getTickets())

        val winningNumbers = InputView.readWinningNumbers()
        val bonusNumber = InputView.readBonusNumber()

        val result = lottoService.calculateResult(lottoTickets, winningNumbers, bonusNumber)
        OutputView.printResult(result, lottoTickets.getTickets().size)
    }
}