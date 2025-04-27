package lotto

class LottoGame(
    private val tickets: List<Lotto>,
    private val winningNumbers: List<Int>,
    private val bonusNumber: Int
) {
    private val winningSet = winningNumbers.toSet()

    fun printResult() {
        // Initialize counters for each prize category
        var firstPrizeCount = 0
        var secondPrizeCount = 0
        var thirdPrizeCount = 0
        var fourthPrizeCount = 0
        var fifthPrizeCount = 0

        // Count how many tickets match each prize category
        for (ticket in tickets) {
            val matchCount = ticket.getNumbers().count { it in winningSet }
            val hasBonus = ticket.getNumbers().contains(bonusNumber)

            when {
                matchCount == 6 -> firstPrizeCount++ // 6 matches (First prize)
                matchCount == 5 && hasBonus -> secondPrizeCount++ // 5 matches + bonus (Second prize)
                matchCount == 5 -> thirdPrizeCount++ // 5 matches (Third prize)
                matchCount == 4 -> fourthPrizeCount++ // 4 matches (Fourth prize)
                matchCount == 3 -> fifthPrizeCount++ // 3 matches (Fifth prize)
            }
        }

        // Print the results
        println("\nWinning Statistics")
        println("---")
        println("6 Matches (2,000,000,000 KRW) – $firstPrizeCount tickets")
        println("5 Matches + Bonus Ball (30,000,000 KRW) – $secondPrizeCount tickets")
        println("5 Matches (1,500,000 KRW) – $thirdPrizeCount tickets")
        println("4 Matches (50,000 KRW) – $fourthPrizeCount tickets")
        println("3 Matches (5,000 KRW) – $fifthPrizeCount tickets")

        // Calculate and print the total return rate
        val totalReward = (firstPrizeCount * 2_000_000_000) +
                (secondPrizeCount * 30_000_000) +
                (thirdPrizeCount * 1_500_000) +
                (fourthPrizeCount * 50_000) +
                (fifthPrizeCount * 5_000)

        val totalSpent = tickets.size * 1000
        val returnRate = (totalReward.toDouble() / totalSpent) * 100

        // Print the return rate rounded to one decimal place
        println("Total return rate is ${"%.1f".format(returnRate)}%.")
    }
}