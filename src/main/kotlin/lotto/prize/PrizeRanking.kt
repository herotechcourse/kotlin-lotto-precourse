package lotto.prize

import lotto.Lotto

class PrizeRanking {

    // Function to calculate prize based on matching numbers and bonus number
    fun calculatePrize(userNumbers: List<Int>, winningNumbers: List<Int>, bonusNumber: Int): String {
        val matchingNumbers = userNumbers.intersect(winningNumbers).size
        val isBonusMatch = userNumbers.contains(bonusNumber)

        return when {
            matchingNumbers == 6 -> "6 Matches (2,000,000,000 KRW)"
            matchingNumbers == 5 && isBonusMatch -> "5 Matches + Bonus Ball (30,000,000 KRW)"
            matchingNumbers == 5 -> "5 Matches (1,500,000 KRW)"
            matchingNumbers == 4 -> "4 Matches (50,000 KRW)"
            matchingNumbers == 3 -> "3 Matches (5,000 KRW)"
            else -> ""
        }
    }


    // Function to process all tickets and store the prize results
    fun calculatePrizeForAllTickets(tickets: List<Lotto>, winningNumbers: List<Int>, bonusNumber: Int): List<String> {
        val prizeResults = mutableListOf<String>()

        // For each generated ticket, calculate and store the prize
        for (ticket in tickets) {
            val prize = calculatePrize(ticket.getNumbers(), winningNumbers, bonusNumber)
            if (prize.isNotEmpty()) {
                prizeResults.add("Ticket ${ticket.getNumbers()} - Prize: $prize")
            }
        }

        return prizeResults
    }

    // Function to calculate the total number of each type of winnings
    fun calculateTotalWinnings(prizeResults: List<String>): Map<String, Int> {
        val winningsCount = mutableMapOf<String, Int>()

        prizeResults.forEach { result ->
            val prize = result.split(" - Prize: ")[1]

            winningsCount[prize] = winningsCount.getOrDefault(prize, 0) + 1
        }

        return winningsCount
    }

}
