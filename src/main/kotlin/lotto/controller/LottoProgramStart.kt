package lotto.controller

import lotto.model.LottoNumberMaker
import lotto.model.PurchaseAmountParser
import lotto.view.InputView
import lotto.view.OutputView
import lotto.model.MatchCalculator

object LottoProgramStart {

    fun run() {
        val purchaseAmount = InputView.readPurchaseAmount()
        val ticketCount = PurchaseAmountParser.parse(purchaseAmount)

        OutputView.printTicketCount(ticketCount)
        val lottoNumber: List<List<Int>> = LottoNumberMaker.makeTotalLottoNumber(ticketCount)
        LottoNumberMaker.printTotalLottoNumber(lottoNumber)

        val winningNumbers: List<String> = WinningNumbersHandler.readValidatedWinningNumbers()
        val bonusNumber: String = BonusNumberHandler.readValidatedBonusNumber(winningNumbers)

        MatchCalculator.run(lottoNumber, winningNumbers, bonusNumber)

        OutputView.printWinningStatisticsStartLine()
        OutputView.printWinningStatistics()
    }

}