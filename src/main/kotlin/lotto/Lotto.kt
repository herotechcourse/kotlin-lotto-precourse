package lotto

import lotto.views.InputView
import lotto.views.OutputView

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] Lotto must contain exactly 6 numbers." }
        require(numbers.toSet().size == 6) { "[ERROR] Lotto numbers must be unique." }
    }

    companion object {
        fun start(): List<String> {
            val inputView = InputView()
            val outputView = OutputView()

            // Step 1: Generate tickets
            val tickets = generateLottoTickets()

            // Step 2: Get winning numbers and lucky number
            val winningNumbers = inputView.inputWinningNumber()
            val luckyNumber = inputView.inputSingleNumber(winningNumbers)

            // Step 3: Prepare outputs
            val ticketOutput = outputView.displayTickets(tickets)
            val results = checkWinningTickets(tickets, winningNumbers, luckyNumber)
            val resultCounts = calculateResultCounts(results)
            val resultsOutput = outputView.displayResults(resultCounts)
            val totalPrizeOutput = outputView.displayTotalPrize(resultCounts, tickets.count())

            // Combine all outputs into a single list
            return ticketOutput + resultsOutput + listOf(totalPrizeOutput)
        }
    }

}
