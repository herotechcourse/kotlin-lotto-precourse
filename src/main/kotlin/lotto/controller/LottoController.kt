package lotto.controller

import lotto.domain.LottoMachine
import lotto.view.OutputView
import lotto.domain.WinningLotto

object LottoController {
    fun start(){
        val purchaseAmount = InputHandler.requestPurchaseAmount()
        val lottoMachine = LottoMachine(purchaseAmount)
        OutputView.printTickets(lottoMachine.tickets)

        val winningNumbers = InputHandler.requestWinningTicket()
        val bonusNumber = InputHandler.requestBonusNumber(winningNumbers)
        val winningLotto = WinningLotto(winningNumbers,bonusNumber)
    }
}