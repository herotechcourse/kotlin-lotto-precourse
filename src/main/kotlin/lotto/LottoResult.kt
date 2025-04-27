package lotto.domain

// Format an integer with commas
private fun Int.formatWithComma(): String = String.format("%,d", this)

// Manage, print Lotto result statistics
class LottoResult {

    // Store the number of wins for each rank
    private val results = mutableMapOf<Rank, Int>()

    // Record a win for the given rank
    fun record(rank: Rank) {

        // Increment the count for the given rank, set it to 1 if not present
        results[rank] = results.getOrDefault(rank, 0) + 1
    }

    // Print the Lotto result statistics and total return rate
    fun print(purchaseAmount: Int) {

        // Print the header for the winning statistics
        println("\nWinning Statistics\n---")

        // For each rank except MISS, print the number of matches, prize, tickets won
        Rank.values().filter { it != Rank.MISS }.sortedBy { it.match }.forEach {

            // Print match result, prize amount with commas, number of winning tickets
            println("${it.match} Matches${if (it == Rank.SECOND) " + Bonus Ball" else ""} (${it.prize.formatWithComma()} KRW) – ${results[it] ?: 0} tickets")
        }

        // Calculate the total winnings
        val totalWinnings = results.entries.sumOf { it.key.prize * it.value }

        // Calculate the return rate in percentage
        val rate = totalWinnings.toDouble() / purchaseAmount * 100

        // Print the total return rate
        println("Total return rate is %.1f%%.".format(rate))
    }
}