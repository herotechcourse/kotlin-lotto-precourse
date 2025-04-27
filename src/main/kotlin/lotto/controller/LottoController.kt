package lotto.controller

import lotto.Lotto
import lotto.enums.Rank
import lotto.model.Game
import lotto.model.LottoTicketMachine
import lotto.model.WinningLotto
import lotto.view.*

class LottoController(private val inputView: InputView, private val outputView: OutputView, private val lottoTicketMachine: LottoTicketMachine) {

    fun start() {
        val purchaseAmount = getPurchaseAmount()
        val purchaseQuantity = purchaseAmount.amount / 1_000

        val lottoTicket = lottoTicketMachine.buyLotto(purchaseQuantity)
        outputView.printPurchasedLottoTicket(purchaseQuantity, lottoTicket)

        val winningLotto = getWinningLotto()

        val game = Game(purchaseAmount.amount, lottoTicket, winningLotto)

        val matchResult = game.match()
        val returnRate = game.countReturnRate()
        printMatchResult(matchResult, returnRate)
    }

    private fun printMatchResult(matchResult: Map<Rank, Int>, returnRate: Double) {
        val matchResultDtoList = MatchResultDto.getMatchResultDto(matchResult)
        outputView.printWinningStatistics(matchResultDtoList, returnRate)
    }

    private fun getWinningLotto(): WinningLotto {
        val winningNumbers = getWinningNumbers()
        val bonusNumber = getBonusNumber()
        return WinningLotto(Lotto(winningNumbers.winningNumbers), bonusNumber.bonusNumber)
    }

    private fun getPurchaseAmount(): PurchaseAmountDto {
        try {
            outputView.askPurchaseAmount()
            return inputView.askPurchaseAmount()
        } catch (ex: Exception) {
            println(ex.message)
            return getPurchaseAmount()
        }
    }

    private fun getWinningNumbers(): WinningNumbersDto {
        try {
            outputView.askWinningNumbers()
            return inputView.askWinningNumbers()
        } catch (ex: Exception) {
            println(ex.message)
            return getWinningNumbers()
        }
    }

    private fun getBonusNumber(): BonusNumberDto {
        try {
            outputView.askBonusNumber()
            return inputView.askBonusNumber()
        } catch (ex: Exception) {
            println(ex.message)
            return getBonusNumber()
        }
    }
}
