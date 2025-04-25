package lotto

import views.OutputView
import views.InputView

fun main() {
   var inputView = InputView()
   val outputView = OutputView()
   val lottoMachine = LottoMachine()

   var purchaseAmount=inputView.getPurchaseAmount()
   val ticketsCount=lottoMachine.calcTicketNumber(purchaseAmount)
   val tickets=lottoMachine.issueTickets(ticketsCount)
   outputView.printTickets(tickets)
   val winningNumbers=inputView.getWinningNumbers()
   val bonusNumber=inputView.getBonusNumber()
   lottoMachine.checkMatches(winningNumbers, bonusNumber)
   outputView.printMatches(lottoMachine.matchMap)
   val returnRate=lottoMachine.calcReturnRate(purchaseAmount)
   outputView.printReturnRate(returnRate)
}
