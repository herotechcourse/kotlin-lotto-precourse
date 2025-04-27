package lotto.controller

import lotto.Lotto
import lotto.model.Game
import lotto.model.LottoTicketMachine
import lotto.model.WinningLotto
import lotto.view.*

class LottoController() {

    private val inputView: InputView = InputView()
    private val outputView: OutputView = OutputView()
    private val lottoTicketMachine: LottoTicketMachine = LottoTicketMachine()

    fun start() {
        val purchaseAmount = getPurchaseAmount()
        val purchaseQuantity = purchaseAmount.amount / 1_000

        val lottoTicket = lottoTicketMachine.buyLotto(purchaseQuantity)
        outputView.printPurchasedLottoTicket(purchaseQuantity, lottoTicket)

        val winningLotto = getWinningLotto()
        val game = Game(purchaseAmount.amount, lottoTicket, winningLotto)

        val matchResult = game.match()
        val matchResultDto = MatchResultDto.getMatchResultDto(matchResult)
        val returnRate = game.countReturnRate()
        outputView.printWinningStatistics(matchResultDto, returnRate)
    }

    private fun getWinningLotto(): WinningLotto {
        val winningNumbers = getWinningNumbers()
        val bonusNumber = getBonusNumber()
        return WinningLotto(Lotto(winningNumbers.winningNumbers), bonusNumber.bonusNumber)
    }

    private fun getPurchaseAmount(): PurchaseAmountDto {
        outputView.askPurchaseAmount()
        return inputView.askPurchaseAmount()
    }

    private fun getWinningNumbers(): WinningNumbersDto {
        outputView.askWinningNumbers()
        return inputView.askWinningNumbers()
    }

    private fun getBonusNumber(): BonusNumberDto {
        outputView.askBonusNumber()
        return inputView.askBonusNumber()
    }
}
