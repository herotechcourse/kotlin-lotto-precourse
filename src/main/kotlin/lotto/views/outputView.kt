package lotto.views

import lotto.LottoResults

class OutputView {

    fun displayTickets(tickets: List<List<Int>>): List<String> {
        val output = mutableListOf<String>()
        output.add("You have purchased ${tickets.size} tickets.")
        tickets.forEach { ticket ->
            output.add(ticket.toString())
        }
        return output
    }

    fun displayResults(resultCounts: Map<LottoResults, Int>): List<String> {
        val output = mutableListOf<String>()
        output.add("Winning Statistics")
        output.add("---")
        resultCounts.forEach { (result, count) ->
            output.add("${result.message} – $count tickets")
        }
        return output
    }

    fun displayTotalPrize(resultCounts: Map<LottoResults, Int>, numberOfTickets: Int, ticketPrice: Int = 1000): String {
        var totalPrize = 0
        resultCounts.forEach { (result, count) ->
            totalPrize += result.prize * count
        }

        val totalSpent = numberOfTickets * ticketPrice
        val percentage = (totalPrize.toDouble() / totalSpent) * 100
        return "Total return rate is ${"%.1f".format(percentage)}%."
    }
}
