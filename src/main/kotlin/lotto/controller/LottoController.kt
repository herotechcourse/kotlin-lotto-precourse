package lotto.controller

import lotto.domain.LottoMachine
import lotto.domain.WinningLotto
import lotto.util.InputValidator
import lotto.view.InputView
import lotto.view.OutputView

class LottoController(
    private val inputView: InputView,
    private val outputView: OutputView,
    private val lottoMachine: LottoMachine,
    private val inputValidator: InputValidator
) {
    fun run() {
        val purchaseAmount = getValidPurchaseAmount()
        val purchasedLottos = lottoMachine.buyTickets(purchaseAmount)
        outputView.displayPurchasedTickets(purchasedLottos.size, purchasedLottos)
        val winningNumbers = getValidWinningNumbers()
        val bonusNumber = getValidBonusNumber()
        val winningLotto = WinningLotto(winningNumbers, bonusNumber)
        val lottoResults = lottoMachine.calculateResults(purchasedLottos, winningLotto)
        outputView.displayWinningStatistics(lottoResults)
        outputView.displayProfitRate(lottoResults, purchaseAmount)
    }

    private fun getValidPurchaseAmount(): Int{
        while(true) {
            try {
                val amountString = inputView.readAmount()
                val amount = inputValidator.validateAndParseAmount(amountString)
                return amount
            } catch (e: IllegalArgumentException) {
            }
        }
    }

    private fun getValidWinningNumbers(): List<Int> {
        while(true) {
            try {
                val numberString = inputView.readWinningNumbers()
                val numbers = inputValidator.validateAndParseWinningNums(numberString)
                return numbers
            } catch (e: IllegalArgumentException) {
            }
        }
    }

    private  fun getValidBonusNumber(): Int {
        while(true) {
            try {
                val bonusString = inputView.readBonusNumber()
                val bonus = inputValidator.validateAndParseBonusNum(bonusString)
                return bonus
            } catch (e: IllegalArgumentException) {
            }
        }
    }
}