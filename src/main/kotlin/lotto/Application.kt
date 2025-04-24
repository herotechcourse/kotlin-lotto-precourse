package lotto

fun main() {
    val lottoTicketMachine = LottoTicketMachine(Input(), Validator(), Output())

    val purchaseAmount = lottoTicketMachine.enterPurchaseAmount()
    val issuedTickets = lottoTicketMachine.issueTickets(purchaseAmount)
    val winningNumbers = lottoTicketMachine.enterWinningNumbers()
    val bonusNumber = lottoTicketMachine.enterBonusNumber()

    val lotto = Lotto(winningNumbers)
    lottoTicketMachine.winningStatistics(lotto, issuedTickets, bonusNumber, purchaseAmount)
}
