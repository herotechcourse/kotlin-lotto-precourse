package lotto

import views.OutputView
import views.InputView
import helpers.withReprompt

fun main() {
   var inputView = InputView()
   val outputView = OutputView()
   val lottoMachine = LottoMachine()

   var purchaseAmount=withReprompt{inputView.getPurchaseAmount()}
   val ticketsCount=lottoMachine.calcTicketNumber(purchaseAmount)
   val tickets=lottoMachine.issueTickets(ticketsCount)
   outputView.printTickets(tickets)
   val winningNumbers=withReprompt{inputView.getWinningNumbers()}
   val bonusNumber=withReprompt{inputView.getBonusNumber()}
   lottoMachine.checkMatches(tickets, winningNumbers, bonusNumber)
   outputView.printMatches(lottoMachine.matchMap)
   val returnRate=lottoMachine.calcReturnRate(purchaseAmount)
   outputView.printReturnRate(returnRate)
}
