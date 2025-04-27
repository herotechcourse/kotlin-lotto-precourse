package lotto.controller

import lotto.Lotto
import lotto.exception.ExceptionMessage
import lotto.model.WinningLotto
import lotto.service.LottoService
import lotto.view.InputView
import lotto.view.OutputView

class LottoController(private val inputView: InputView,
                      private val outputView: OutputView,
                      private val lottoService: LottoService
) {
    fun run() {
        try {
            val purchaseAmount = getPurchaseAmount()
            val tickets = purchaseTickets(purchaseAmount)
            outputView.printPurchasedTickets(tickets)

            val winningNumbers = getWinningNumbers()
            val bonusNumber = getBonusNumber(winningNumbers)
            val winningLotto = WinningLotto(winningNumbers, bonusNumber)

            val result = lottoService.matchLottos(tickets, winningLotto)
            outputView.printLottoResult(result)
        } catch (e: IllegalArgumentException) {
            outputView.printError(e.message ?: ExceptionMessage.GENERIC_ERROR.message)
            run()
        }
    }

    private fun getPurchaseAmount(): Int {
        return inputView.readPurchaseAmount()
    }

    private fun purchaseTickets(amount: Int): List<Lotto> {
        return lottoService.createLottoTickets(amount)
    }

    private fun getWinningNumbers(): List<Int> {
        val input = inputView.readWinningNumbers()
        lottoService.validateWinningNumbers(input)
        return input
    }

    private fun getBonusNumber(winningNumbers: List<Int>): Int {
        val bonusNumber = inputView.readBonusNumber()
        lottoService.validateBonusNumber(bonusNumber, winningNumbers)
        return bonusNumber
    }
}