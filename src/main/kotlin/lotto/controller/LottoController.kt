package lotto.controller

import lotto.Lotto
import lotto.enums.Rank
import lotto.error.ExceptionMessage
import lotto.model.Game
import lotto.model.LottoTicketMachine
import lotto.model.WinningLotto
import lotto.view.*
import lotto.view.dto.BonusNumberDto
import lotto.view.dto.MatchResultDto
import lotto.view.dto.PurchaseAmountDto
import lotto.view.dto.WinningNumbersDto

class LottoController(private val inputView: InputView, private val outputView: OutputView, private val lottoTicketMachine: LottoTicketMachine) {

    fun start() {
        val purchaseAmount = getInput {getPurchaseAmount()}
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
        val winningNumbers = getInput {getWinningNumbers()}
        println()
        val bonusNumber = getInput {getBonusNumber(winningNumbers)}
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

    private fun getBonusNumber(winningNumbers: WinningNumbersDto): BonusNumberDto {
        outputView.askBonusNumber()
        val bonusNumber = inputView.askBonusNumber()
        if(winningNumbers.winningNumbers.contains(bonusNumber.bonusNumber)) throw IllegalArgumentException(ExceptionMessage.INVALID_BONUS_NUMBER.errorMessage)
        return bonusNumber
    }

    private fun <T> getInput(input: () -> T):T {
        while(true) {
            try {
                return input()
            } catch (ex: IllegalArgumentException) {
                println(ex.message)
            }
        }
    }
}
