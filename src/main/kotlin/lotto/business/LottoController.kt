package lotto.business

import lotto.*
import lotto.ui.InputView
import lotto.ui.OutputView

class LottoController {
    fun run() {
        val purchaseAmount = inputPurchaseAmount()
        val lottoList = outputLotteryTickets(purchaseAmount)

        val winningNumber = inputWinningNumber()
        val bonusNumber = inputBonusNumber(winningNumber)

        outputWinningStatistics(purchaseAmount, lottoList, winningNumber, bonusNumber)
    }

    private fun inputPurchaseAmount(): PurchaseAmount {
        while (true) {
            try {
                val purchaseAmountInput = InputView.getPurchaseAmount()
                return PurchaseAmount.from(purchaseAmount = purchaseAmountInput)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    private fun outputLotteryTickets(purchaseAmount: PurchaseAmount): List<Lotto> {
        val lottoList = Lotto.generateLottoList(purchaseAmount = purchaseAmount)
        OutputView.printLotteryTicketsOutputMessage(purchaseAmount, lottoList)
        return lottoList
    }

    private fun inputWinningNumber(): WinningNumber {
        while (true) {
            try {
                val winningNumberInput = InputView.getWinningNumbers()
                return WinningNumber.from(numbers = winningNumberInput)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    private fun inputBonusNumber(winningNumber: WinningNumber): BonusNumber {
        while (true) {
            try {
                val bonusNumberInput = InputView.getBonusNumber()
                return BonusNumber.from(number = bonusNumberInput, winningNumber = winningNumber)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    private fun outputWinningStatistics(
        lottoList: List<Lotto>, winningNumber: WinningNumber, bonusNumber: BonusNumber
    ) {
        val lottoResult = LottoResult.from(lottoList, winningNumber, bonusNumber)
        val profitRate = lottoResult.getProfitRate()
        OutputView.printWinningStatisticsOutputMessage(lottoResult)
        OutputView.printProfitRateOutputMessage(profitRate)
    }
}