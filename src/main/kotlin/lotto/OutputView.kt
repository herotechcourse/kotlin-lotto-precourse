package lotto

object OutputView {
    fun printError(message: String) {
        println("\u001B[31mError: $message\u001B[0m")
    }

    fun printResults(results: Map<PrizeRank, Int>, totalSpent: Int) {
        val totalWon = results.entries.sumOf { it.key.amount * it.value }

        println("\n--- Results ---")
        PrizeRank.entries.forEach { rank ->
            println("${rank.name.lowercase().replaceFirstChar { it.uppercase() }}: ${results[rank] ?: 0}")
        }
        println("Total Return: ${(totalWon.toDouble() / totalSpent * 100).format(2)}%")
    }

    private fun Double.format(decimals: Int) =
        "%.${decimals}f%%".format(this)
}