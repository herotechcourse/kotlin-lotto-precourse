package lotto

fun main() {
    val input = Input(Validator())
    val output = Output()
    val issuedTicket = input.enterPurchaseAmount()
    val issuedTickets = IssuedTicketsGenerator.of(issuedTicket)
    output.printIssuedTickets(issuedTicket.getCount(), issuedTickets)

    val lotto = input.enterWinningNumbers()
    val bonusNumber = input.enterBonusNumber(lotto)
    lotto.simulate(issuedTickets, bonusNumber)
    output.printWinningStatistics(lotto.getProfitRate(issuedTicket.purchaseAmount))
}
