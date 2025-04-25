package lotto.controller

import lotto.model.LottoResult
import lotto.model.LottoTicket
import lotto.model.WinningLotto
import lotto.service.LottoService
import lotto.view.LottoInputView
import lotto.view.LottoOutputView

class LottoController(
    private val lottoInputView: LottoInputView,
    private val lottoOutputView: LottoOutputView,
    private val lottoService: LottoService
) {

    fun run() {
        val lottoTicket = buyLottoTicket()
        lottoOutputView.printLottoCount(lottoTicket.getLottosCount())
        lottoOutputView.printLottoTicket(lottoTicket.getLottoTicketNumbers())

        val winningLotto = makeWinningNumber()
        addBonusNumber(winningLotto)

        val lottoResult = compareLottoTicketWithWinningLotto(lottoTicket, winningLotto)
        val totalEarnings = lottoService.calculateEarnings(lottoResult.getRankResults(), lottoTicket)
        lottoOutputView.printLottoResult(lottoResult.getRankResults(), totalEarnings)
    }

    private fun compareLottoTicketWithWinningLotto(lottoTicket: LottoTicket, winningLotto: WinningLotto): LottoResult {
        return lottoService.compareLotto(lottoTicket, winningLotto)
    }

    private fun addBonusNumber(winningLotto: WinningLotto) {
        while (true) {
            try {
                val bonusNumber = lottoInputView.getBonusNumber()
                lottoService.addBonusNumber(winningLotto, bonusNumber)
                return
            } catch (e: IllegalArgumentException) {
                lottoOutputView.printExceptionMessage(e)
            }
        }
    }

    private fun makeWinningNumber(): WinningLotto {
        while (true) {
            try {
                val winningNumber = lottoInputView.getWinningNumber()
                return lottoService.createWinningLotto(winningNumber)
            } catch (e: IllegalArgumentException) {
                lottoOutputView.printExceptionMessage(e)
            }
        }
    }

    private fun buyLottoTicket(): LottoTicket {
        while (true) {
            try {
                val purchaseMoney = lottoInputView.getLottoPurchaseMoney()
                return lottoService.createLottoTicket(purchaseMoney)
            } catch (e: IllegalArgumentException) {
                lottoOutputView.printExceptionMessage(e)
            }
        }
    }
}
