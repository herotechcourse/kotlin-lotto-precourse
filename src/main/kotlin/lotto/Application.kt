package lotto

import lotto.input.PurchaseAmountInputReader
import lotto.input.BonusNumberInputReader
import lotto.input.WinningNumberInputReader
import lotto.calculation.TicketCalculator
import lotto.calculation.TicketGenerator
import lotto.display.TicketDisplay
import lotto.prize.PrizeRanking

fun main() {

    //Read Purchase Amount input from the user
    val purchaseAmount = PurchaseAmountInputReader().read()

    // Calculate the number of tickets
    val numberOfTickets = TicketCalculator().calculateNumberOfTickets(purchaseAmount)

    // Generate random tickets as Lotto objects
    val tickets = TicketGenerator().generateTickets(numberOfTickets)

    // Display the generated Lotto tickets
    TicketDisplay().displayTickets(numberOfTickets, tickets)

    //Read Winning Number input from the user
    val winningNumber = WinningNumberInputReader().read()

    //Read Bonus Number input from the user
    val bonusNumber = BonusNumberInputReader().read()

    // Prize Ranking
    val prizeResults = PrizeRanking().calculatePrizeForAllTickets(tickets, winningNumber, bonusNumber)

    // Calculate total winnings
    val totalWinnings = PrizeRanking().calculateTotalWinnings(prizeResults)

}
