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
            val tickets = generateLottoTickets()
            val winningNumbers = inputView.inputWinningNumber()
            val luckyNumber = inputView.inputSingleNumber(winningNumbers)
            val ticketOutput = outputView.displayTickets(tickets)
            val results = checkWinningTickets(tickets, winningNumbers, luckyNumber)
            val resultCounts = calculateResultCounts(results)
            val resultsOutput = outputView.displayResults(resultCounts)
            val totalPrizeOutput = outputView.displayTotalPrize(resultCounts, tickets.count())
            return ticketOutput + resultsOutput + listOf(totalPrizeOutput)
        }
    }

}
