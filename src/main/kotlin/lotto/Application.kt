package lotto

fun main() {
    // TODO: Implement the program
    OutputView.askForPurchaseAmount()
    LotteryTicketMachine.generateTickets(LotteryTicketMachine.purchaseAmount)
    OutputView.askForWinningNumbers()
    OutputView.askForBonusNumber()
    LotteryTicketMachine.evaluateTickets()
    LotteryTicketMachine.calculateReturnRate()
    OutputView.printWinnings(LotteryTicketMachine.winnings, PrizeRank.entries)
}
