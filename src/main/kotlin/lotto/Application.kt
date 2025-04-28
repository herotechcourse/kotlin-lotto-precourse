package lotto

fun main() {
    val amount = InputView.getUserPurchaseAmount()
//    val amount = InputView.parsePurchaseAmount("1000")

    val numberOfTickets = amount / const.TICKET_PRICE
    val tickets = LottoTickets.generate(numberOfTickets)
    OutputView.printTickets(tickets)

    val winningNumbers = InputView.getUserWinningNumbers()
    val bonusNumbers = InputView.getUserBonusNumbers(winningNumbers)
//    val winningNumbers = InputView.parseWinningNumbers("1,20,13,4,5,7")
//    val bonusNumbers = InputView.parseBonusNumbers("8", winningNumbers)
    OutputView.printStatistics(tickets, winningNumbers, bonusNumbers)
}
