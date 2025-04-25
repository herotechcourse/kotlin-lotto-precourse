package lotto

fun main() {
    val issuedTicket = Input.enterPurchaseAmount()
    val issuedTickets = IssuedTicketsGenerator.of(issuedTicket)
    Output.printIssuedTickets(issuedTicket.getCount(), issuedTickets)

    val lotto = Input.enterWinningNumbers()
    val bonusNumber = Input.enterBonusNumber(lotto)
    val statistics = LottoStatistics.of()

    lotto.simulate(issuedTickets, bonusNumber, statistics)
    Output.printWinningStatistics(statistics, issuedTicket.purchaseAmount)
}
