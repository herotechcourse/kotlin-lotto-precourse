package lotto.business

import lotto.*
import lotto.ui.InputView
import lotto.ui.OutputView

class LottoController {
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
}