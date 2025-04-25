package lotto
import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms



fun main() {
    // TODO: Implement the program

        val purchaseAmount = readPurchaseAmount()
        val ticketCount = purchaseAmount / 1000
        val tickets = generateTickets(ticketCount)
        println("\nYou have purchased $ticketCount tickets.")
        tickets.forEach { println(it.numbers) }

        val winningNumbers = readWinningNumbers()
        val bonusNumber = readBonusNumber()

        val statistics = LottoStatistics(winningNumbers, bonusNumber)
        tickets.forEach { statistics.checkResult(it) }

        statistics.printResults()
    }

    fun readPurchaseAmount(): Int {
        println("Please enter the purchase amount (must be divisible by 1000)")
        val input = Console.readLine()
        return input.toIntOrNull()?.takeIf { it % 1000 == 0 } ?: throw IllegalArgumentException("[ERROR] Remember: the amount must be divisible by 1000.")
    }

    fun generateTickets(count: Int): List<Loteria> = List(count) {
        val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted()
        Loteria(numbers)
    }

    fun readWinningNumbers(): List<Int> {
        println("\nPlease enter last week's winning numbers (6 unique numbers between 1 and 45)")
        return Console.readLine()
            .split(",")
            .map { it.trim().toInt() }
            .also {
                if (it.size != 6 || it.toSet().size != 6 || it.any { n -> n !in 1..45 })
                    throw IllegalArgumentException("[ERROR] Winning numbers must be 6 unique numbers between 1 and 45.")
            }
    }

    fun readBonusNumber(): Int {
        println("\nPlease enter the bonus number (must be between 1 and 45)")
        val number = Console.readLine().toInt()
        if (number !in 1..45) throw IllegalArgumentException("[ERROR] Bonus number must be between 1 and 45.")
        return number
    }

    class Loteria(val numbers: List<Int>) {
        init {
            require(numbers.size == 6) { "[ERROR] Lotto must contain exactly 6 numbers." }
        }
    }

    class LottoStatistics(private val winningNumbers: List<Int>, private val bonusNumber: Int) {
        private val results = mutableMapOf<Int, Int>()

        fun checkResult(ticket: Loteria) {
            val matchCount = ticket.numbers.count { it in winningNumbers }
            val bonusMatch = bonusNumber in ticket.numbers

            val rank = when {
                matchCount == 6 -> 1
                matchCount == 5 && bonusMatch -> 2
                matchCount == 5 -> 3
                matchCount == 4 -> 4
                matchCount == 3 -> 5
                else -> null
            }

            rank?.let { results[it] = results.getOrDefault(it, 0) + 1 }
        }

        fun printResults() {
            println("\nWinning Statistics")
            println("---")
            println("3 Matches (5,000 KRW) – ${results[5] ?: 0} tickets")
            println("4 Matches (50,000 KRW) – ${results[4] ?: 0} tickets")
            println("5 Matches (1,500,000 KRW) – ${results[3] ?: 0} tickets")
            println("5 Matches + Bonus Ball (30,000,000 KRW) – ${results[2] ?: 0} tickets")
            println("6 Matches (2,000,000,000 KRW) – ${results[1] ?: 0} tickets")

            val totalReward = (results[1] ?: 0) * 2_000_000_000 +
                    (results[2] ?: 0) * 30_000_000 +
                    (results[3] ?: 0) * 1_500_000 +
                    (results[4] ?: 0) * 50_000 +
                    (results[5] ?: 0) * 5_000
            val spent = (results.values.sum()) * 1000
            val rate = if (spent > 0) totalReward.toDouble() / spent * 100 else 0.0
            println("Total return rate is ${"%.1f".format(rate)}%.")
        }

}