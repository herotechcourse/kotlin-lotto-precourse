package lotto

class ProfitCalculator() {
    fun calculate(budget: Int, winningResults: List<TicketResults>): Double {
        var totalWinning = 0.0
        winningResults.forEach { result ->
            totalWinning += (result.prize.amount)
        }

        val rate = (totalWinning / budget) * 100
        return rate
    }
}

// 1505000
