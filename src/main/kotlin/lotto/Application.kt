package lotto

fun main() {
   var inputView =InputView()
   val lottoMachine=LottoMachine()

   var purchaseAmount=inputView.getPurchaseAmount()
   val ticketsCount=lottoMachine.calcTicketNumber(purchaseAmount)
   
}
