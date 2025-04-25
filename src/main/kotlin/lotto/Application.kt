package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

class Application {
    fun main() {
        try {
            val purchaseAmount = promptPurchaseAmount()
            val tickets = generateTickets(purchaseAmount)

            OutputView.printTickets(tickets)

            val winningNumbers = promptWinningNumbers()
            val bonusNumber = promptBonusNumber(winningNumbers)

            val results = calculateResults(tickets, winningNumbers, bonusNumber)
            OutputView.printResults(results, purchaseAmount)
        } catch (e: IllegalArgumentException) {
            OutputView.printErrorMessage(e.message ?: "[ERROR] An unexpected error occurred.")
        }
    }

    private fun promptPurchaseAmount(): Int {
        OutputView.promptPurchaseAmountMessage()
        val input = Console.readLine()
        val amount = input.toIntOrNull()
            ?: throw IllegalArgumentException("[ERROR] Purchase amount must be a positive number.")
        require(amount % 1000 == 0) { "[ERROR] Purchase amount must be divisible by 1,000." }
        return amount
    }

    private fun generateTickets(purchaseAmount: Int): List<Lotto> {
        val ticketCount = purchaseAmount / 1000
        return List(ticketCount) { Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)) }
    }

    private fun promptWinningNumbers(): Set<Int> {
        OutputView.promptWinningNumbersMessage()
        val input = Console.readLine()
        val numbers = parseNumbers(input)
        validateNumbers(numbers)
        return numbers
    }

    private fun promptBonusNumber(winningNumbers: Set<Int>): Int {
        OutputView.promptBonusNumberMessage()
        val input = Console.readLine()
        val bonusNumber = input.toIntOrNull()
            ?: throw IllegalArgumentException("[ERROR] Input must be a valid number.")
        validateBonusNumber(bonusNumber, winningNumbers)
        return bonusNumber
    }

    private fun calculateResults(tickets: List<Lotto>, winningNumbers: Set<Int>, bonusNumber: Int): Map<MatchResult, Int> {
        val results = mutableMapOf<MatchResult, Int>().apply {
            MatchResult.values().forEach { this[it] = 0 }
        }
        tickets.forEach { ticket ->
            val matchCount = ticket.getNumbers().intersect(winningNumbers).size
            updateResults(results, matchCount, ticket.getNumbers().contains(bonusNumber))
        }
        return results
    }

    private fun updateResults(results: MutableMap<MatchResult, Int>, matchCount: Int, hasBonus: Boolean) {
        when (matchCount) {
            6 -> results[MatchResult.SIX_MATCHES] = results[MatchResult.SIX_MATCHES]!! + 1
            5 -> {
                if (hasBonus) {
                    results[MatchResult.FIVE_MATCHES_BONUS] = results[MatchResult.FIVE_MATCHES_BONUS]!! + 1
                } else {
                    results[MatchResult.FIVE_MATCHES] = results[MatchResult.FIVE_MATCHES]!! + 1
                }
            }
            4 -> results[MatchResult.FOUR_MATCHES] = results[MatchResult.FOUR_MATCHES]!! + 1
            3 -> results[MatchResult.THREE_MATCHES] = results[MatchResult.THREE_MATCHES]!! + 1
        }
    }

    private fun parseNumbers(input: String): Set<Int> = input.split(",").mapNotNull { it.trim().toIntOrNull() }.toSet()

    private fun validateNumbers(numbers: Set<Int>) {
        require(numbers.size == 6) { "[ERROR] Winning numbers must consist of exactly 6 unique numbers." }
        require(numbers.all { it in 1..45 }) { "[ERROR] Winning numbers must be between 1 and 45." }
    }

    private fun validateBonusNumber(bonusNumber: Int, winningNumbers: Set<Int>) {
        require(bonusNumber in 1..45 && bonusNumber !in winningNumbers) {
            "[ERROR] Bonus number must be between 1 and 45, and not in the winning numbers."
        }
    }
}

enum class MatchResult(val label: String, val prize: Int) {
    SIX_MATCHES("6 Matches", 2_000_000_000),
    FIVE_MATCHES_BONUS("5 Matches + Bonus Ball", 30_000_000),
    FIVE_MATCHES("5 Matches", 1_500_000),
    FOUR_MATCHES("4 Matches", 50_000),
    THREE_MATCHES("3 Matches", 5_000)
}

object OutputView {
    fun promptPurchaseAmountMessage() = println("Please enter the purchase amount:")

    fun promptWinningNumbersMessage() = println("Please enter last week's winning numbers (comma-separated):")

    fun promptBonusNumberMessage() = println("Please enter the bonus number:")

    fun printTickets(tickets: List<Lotto>) {
        println("You have purchased ${tickets.size} tickets.")
        tickets.forEach { println(it.getNumbers().sorted()) }
    }

    fun printResults(results: Map<MatchResult, Int>, purchaseAmount: Int) {
        println("Winning Statistics")
        println("---")
        var totalPrize = 0
        results.forEach { (result, count) ->
            val prize = result.prize * count
            println("${result.label} (${String.format("%,d KRW", result.prize)}) – $count tickets")
            totalPrize += prize
        }
        val profitRate = ((totalPrize.toDouble() / purchaseAmount) * 100).format(1)
        println("Total return rate is $profitRate%.")
    }

    fun printErrorMessage(message: String) = println(message)
}

fun Double.format(digits: Int): String = "%.${digits}f".format(this)
