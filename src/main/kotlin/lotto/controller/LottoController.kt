package lotto.controller

import lotto.Lottos
import lotto.LottosResult
import lotto.PurchaseAmount
import lotto.WinningNumbers
import lotto.enums.InputType
import lotto.enums.OutputType
import lotto.factory.InputViewFactory
import lotto.factory.OutputViewFactory

class LottoController {
    fun run() {
        try {
            val purchaseView = InputViewFactory.createInputView(InputType.PURCHASE_AMOUNT)
            val purchaseAmount = PurchaseAmount(purchaseView.readInput())

            val ticketCounts = purchaseAmount.getTicketCount()
            val lottos = Lottos(mutableListOf(), ticketCounts)

            val lottosView = OutputViewFactory.createOutputView<Lottos>(OutputType.LOTTOS)
            lottosView.display(lottos)

            val winningNumbersView = InputViewFactory.createInputView(InputType.WINNING_NUMBERS)
            val winningNumbers = winningNumbersView.readInput().split(",")

            val bonusNumberView = InputViewFactory.createInputView(InputType.BONUS_NUMBER)
            val bonusNumber = bonusNumberView.readInput()

            val allNumbers = WinningNumbers(winningNumbers, bonusNumber)

            val lottosResult = LottosResult(lottos, allNumbers)
            val winningStatisticsView = OutputViewFactory.createOutputView<LottosResult>(OutputType.WINNING_STATISTICS)
            winningStatisticsView.display(lottosResult)
        } catch (e: IllegalArgumentException) {
            println(e.message)
        }
    }
}