package lotto.controller

import lotto.model.LottoNumberMaker
import lotto.model.MatchCalculator
import lotto.model.PurchaseAmountParser
import lotto.model.ReturnRateCalculator
import lotto.view.OutputView

object LottoProgramStart {
    fun run() {
        val purchaseAmount = PurchaseAmountHandler.readValidated()
        val ticketCount = PurchaseAmountParser.parse(purchaseAmount)
        OutputView.printTicketCount(ticketCount)

        val lottoNumber = LottoNumberMaker.makeTotalTicket(ticketCount)
        LottoNumberMaker.printTotalTicket(lottoNumber)

        val winningNumbers = WinningNumbersHandler.readValidated()
        val bonusNumber = BonusNumberHandler.readValidated(winningNumbers)

        val winningAmount = MatchCalculator.calculate(lottoNumber, winningNumbers, bonusNumber)
        val returnRate = ReturnRateCalculator.run(purchaseAmount, winningAmount)

        OutputView.printWinningStatisticsStartLine()
        OutputView.printWinningStatistics()
        OutputView.printReturnRate(returnRate)
    }
}
