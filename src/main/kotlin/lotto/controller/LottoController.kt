package lotto.controller

import lotto.domain.LottoMachine
import lotto.domain.LottoResult
import lotto.view.OutputView
import lotto.domain.WinningLotto
import lotto.util.calculateAndFormatReturnRate

object LottoController {
    fun start(){
        val purchaseAmount = InputHandler.requestPurchaseAmount()
        val lottoMachine = LottoMachine(purchaseAmount)
        OutputView.printTickets(lottoMachine.tickets)

        val winningNumbers = InputHandler.requestWinningTicket()
        val bonusNumber = InputHandler.requestBonusNumber(winningNumbers)
        val winningLotto = WinningLotto(winningNumbers,bonusNumber)

        val totalPrize = LottoResult.checkResult(lottoMachine.tickets, winningLotto)
        val returnRate = calculateAndFormatReturnRate(totalPrize, purchaseAmount)
    }
}