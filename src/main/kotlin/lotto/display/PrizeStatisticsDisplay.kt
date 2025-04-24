package lotto.display

import lotto.prize.PrizeRanking

class PrizeStatisticsDisplay {

    // Function to generate the total winnings count
    private fun generateTotalWinnings(prizeResults: List<String>, prizeRanking: PrizeRanking): Map<String, Int> {
        return prizeRanking.calculateTotalWinnings(prizeResults)
    }

    // Function to get the list of possible prizes
    private fun getPossiblePrizes(): List<String> {
        return listOf(
            "3 Matches (5,000 KRW)",
            "4 Matches (50,000 KRW)",
            "5 Matches (1,500,000 KRW)",
            "5 Matches + Bonus Ball (30,000,000 KRW)",
            "6 Matches (2,000,000,000 KRW)"
        )
    }

    // Function to display the prize statistics header
    private fun displayStatisticsHeader() {
        println("Winning Statistics")
        println("---")
    }

    // Function to display the prize count for each prize category
    private fun displayPrizeCount(prize: String, totalWinnings: Map<String, Int>) {
        val count = totalWinnings[prize] ?: 0
        println("$prize – $count tickets")
    }

    // Function to display the prize statistics in the required format
    fun displayPrizeStatistics(prizeResults: List<String>, prizeRanking: PrizeRanking) {
        // Generate total winnings
        val totalWinnings = generateTotalWinnings(prizeResults, prizeRanking)

        // Get list of all possible prizes
        val possiblePrizes = getPossiblePrizes()

        // Display the header
        displayStatisticsHeader()

        // Iterate over the possible prizes and display the count for each
        possiblePrizes.forEach { prize ->
            displayPrizeCount(prize, totalWinnings)
        }
    }
}