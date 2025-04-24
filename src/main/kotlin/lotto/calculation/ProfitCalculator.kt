package lotto.calculation

class ProfitCalculator(private val ticketCalculator: TicketCalculator) {

    // Function to extract the prize amount from a prize result
    private fun getPrizeAmount(prizeResult: String): Int {
        return when {
            prizeResult.contains("6 Matches") -> 2_000_000_000
            prizeResult.contains("5 Matches + Bonus Ball") -> 30_000_000
            prizeResult.contains("5 Matches") -> 1_500_000
            prizeResult.contains("4 Matches") -> 50_000
            prizeResult.contains("3 Matches") -> 5_000
            else -> 0
        }
    }

    // Function to calculate the return rate
    private fun calculateReturnRate(totalPrizeMoney: Int, totalCostOfTickets: Int): Double {
        return (totalPrizeMoney.toDouble() / totalCostOfTickets) * 100
    }

    // Function to calculate the total prize money from the prize results
    fun calculateTotalPrizeMoney(prizeResults: List<String>): Int {
        return prizeResults.sumOf { getPrizeAmount(it) }
    }

    // Function to calculate the return rate based on total prize money and purchase amount
    fun calculateReturnRate(prizeResults: List<String>, purchaseAmount: Int): Double {
        val totalPrizeMoney = calculateTotalPrizeMoney(prizeResults)
        val totalCostOfTickets = purchaseAmount

        return if (totalCostOfTickets > 0) {
            calculateReturnRate(totalPrizeMoney, totalCostOfTickets)
        } else {
            0.0
        }
    }

}