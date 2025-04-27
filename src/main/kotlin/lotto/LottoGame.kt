package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

class LottoGame {

    fun run() {
        val purchaseAmount = inputPurchaseAmount()
        val ticketCount = purchaseAmount / 1000
        val tickets = generateTickets(ticketCount)

        println("You have purchased $ticketCount tickets.")
        tickets.forEach { println(it.getNumbers().sorted()) }

        val winningNumbers = inputWinningNumbers()
        val bonusNumber = inputBonusNumber()

        val results = ResultCalculator.calculateResults(tickets, winningNumbers, bonusNumber)
        displayResults(results, purchaseAmount)
    }

    private fun inputPurchaseAmount(): Int {
        println("Please enter the purchase amount.")
        val amount = Console.readLine().toIntOrNull()
            ?: throw IllegalArgumentException("[ERROR] Please enter a valid number.")

        require(amount % 1000 == 0) { "[ERROR] Amount must be divisible by 1,000." }
        return amount
    }

    private fun generateTickets(count: Int): List<Lotto> {
        return List(count) {
            Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6))
        }
    }

    private fun inputWinningNumbers(): List<Int> {
        println("Please enter last week's winning numbers.")
        val numbers = Console.readLine().split(",").map { it.trim().toInt() }
        require(numbers.size == 6 && numbers.distinct().size == 6) {
            "[ERROR] Enter exactly 6 unique numbers."
        }
        require(numbers.all { it in 1..45 }) {
            "[ERROR] Lotto numbers must be between 1 and 45."
        }
        return numbers
    }

    private fun inputBonusNumber(): Int {
        println("Please enter the bonus number.")
        val number = Console.readLine().toIntOrNull()
            ?: throw IllegalArgumentException("[ERROR] Please enter a valid number.")
        require(number in 1..45) { "[ERROR] Bonus number must be between 1 and 45." }
        return number
    }

    private fun displayResults(results: Map<Int, Int>, purchaseAmount: Int) {
        val prizeMoney = mapOf(3 to 5000, 4 to 50000, 5 to 1500000, 51 to 30000000, 6 to 2000000000)
        val totalPrize = results.entries.sumOf { (rank, count) -> prizeMoney.getValue(rank) * count }
        val profitRate = (totalPrize.toDouble() / purchaseAmount) * 100

        println("\nWinning Statistics\n---")
        println("3 Matches (5,000 KRW) – ${results[3]} tickets")
        println("4 Matches (50,000 KRW) – ${results[4]} tickets")
        println("5 Matches (1,500,000 KRW) – ${results[5]} tickets")
        println("5 Matches + Bonus Ball (30,000,000 KRW) – ${results[51]} tickets")
        println("6 Matches (2,000,000,000 KRW) – ${results[6]} tickets")
        println("Total return rate is ${"%.1f".format(profitRate)}%.")
    }
}
