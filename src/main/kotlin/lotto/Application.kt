package lotto

import views.OutputView

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
}
