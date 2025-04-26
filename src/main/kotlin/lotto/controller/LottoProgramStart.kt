package lotto.controller

import lotto.model.LottoNumberMaker
import lotto.model.MatchCalculator
import lotto.model.PurchaseAmountParser
import lotto.model.ReturnRateCalculator
import lotto.view.InputView
import lotto.view.OutputView

object LottoProgramStart {
    fun run() {
        val purchaseAmount = InputView.readPurchaseAmount()
        val ticketCount = PurchaseAmountParser.parse(purchaseAmount)
        OutputView.printTicketCount(ticketCount)

        val lottoNumber: List<List<Int>> = LottoNumberMaker.makeTotalLottoNumber(ticketCount)
        LottoNumberMaker.printTotalLottoNumber(lottoNumber)

        val winningNumbers: List<String> = WinningNumbersHandler.readValidatedWinningNumbers()
        val bonusNumber: String = BonusNumberHandler.readValidatedBonusNumber(winningNumbers)

        val winningAmount = MatchCalculator.run(lottoNumber, winningNumbers, bonusNumber)
        val returnRate = ReturnRateCalculator.run(purchaseAmount, winningAmount)

        OutputView.printWinningStatisticsStartLine()
        OutputView.printWinningStatistics()
        OutputView.printReturnRate(returnRate)
    }
}
