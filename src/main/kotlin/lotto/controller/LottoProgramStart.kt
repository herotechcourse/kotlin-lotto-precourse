package lotto.controller

import lotto.model.LottoNumberMaker
import lotto.model.PurchaseAmountParser
import lotto.view.InputView
import lotto.view.OutputView

object LottoProgramStart {
    fun run() {
        val purchaseAmount = InputView.readPurchaseAmount()
        val ticketCount = PurchaseAmountParser.parse(purchaseAmount)

        OutputView.printTicketCount(ticketCount)
        val lottoNumber = LottoNumberMaker.makeTotalLottoNumber(ticketCount)
        LottoNumberMaker.printTotalLottoNumber(lottoNumber)
    }
}