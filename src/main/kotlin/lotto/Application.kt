package lotto

import lotto.view.InputView
import lotto.view.OutputView

import lotto.domain.LottoMachine
import lotto.domain.LottoResult
import lotto.domain.Rank


fun main() {
    // TODO: Implement the program
    try {
        // Call the input function to receive the user's purchase amount input
        val purchaseAmount = InputView.readPurchaseAmount()

        // Issue Lotto tickets based on the purchase amount
        val tickets = LottoMachine.issueTickets(purchaseAmount)

        // Print the number of issued Lotto tickets
        OutputView.printTickets(tickets)

        // Read the winning numbers input from the user
        val winningNumbers = InputView.readWinningNumbers()

        // Read the bonus number input from the user
        val bonusNumber = InputView.readBonusNumber()

        // Create an instance to store the Lotto result
        val result = LottoResult()

        // Iterate through each ticket to check matching results
        tickets.forEach { ticket ->

            // Count how many numbers match the winning numbers
            val match = ticket.matchCount(winningNumbers)

            // Check if the ticket contains the bonus number
            val hasBonus = ticket.containsBonus(bonusNumber)

            // Determine the rank based on matches and bonus
            val rank = Rank.from(match, hasBonus)

            // Record the result for the determined rank
            result.record(rank)
        }

        // Print the final Lotto result statistics
        result.print(purchaseAmount)
    } catch (e: IllegalArgumentException) {
        println(e.message)
    }
}
