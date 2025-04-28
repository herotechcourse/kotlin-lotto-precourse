package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    println("\nLotto machine is spinning...\n")
    Application().run()
}

class Application {
    fun run() {
        // defining user input - purchase amount, winning numbers
        val amount = readMoney()
        val tickets = amount / 1000
        println("You've purchased $tickets tickets for $amount Won.\n")

        val lottoTickets = generateTickets(tickets)
        

        // compare tickets to winning numbers and print the results
        val winningNumbers = readWinningNumbers()
        val bonusNumber = readBonusNumber()

        val results = checkResults(lottoTickets, winningNumbers, bonusNumber)

        // println("Your ticket numbers are:\n")
        // lottoTickets.forEach { println(it.numbers) }
        printStatistics(results, amount)
        
    }

    private fun readMoney(): Int {
        print("Enter the amount: ")
        val amount = readLine()?.toIntOrNull()
            ?: throw IllegalArgumentException("[ERROR] Invalid number input.")
        if (amount % 1000 != 0) {
            throw IllegalArgumentException("[ERROR] Amount must be divisible by 1,000.")
        }
        return amount
    }

    private fun readWinningNumbers(): List<Int> {
        print("Enter six winning numbers (comma-separated): ")
        val input = readLine()
            ?: throw IllegalArgumentException("[ERROR] Input cannot be null.")
        val numbers = input.split(",")
            .map { it.trim().toIntOrNull() ?: throw IllegalArgumentException("[ERROR] Invalid number.") }
        if (numbers.size != 6) {
            throw IllegalArgumentException("[ERROR] You must enter exactly 6 numbers.")
        }
        return numbers
    }

    private fun readBonusNumber(): Int {
        print("Enter the bonus number: ")
        return readLine()?.toIntOrNull()
            ?: throw IllegalArgumentException("[ERROR] Please pick only one bonus number.")
    }

    private fun generateTickets(count: Int): List<LottoTicket> {
        return List(count) {
            val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted()
            LottoTicket(numbers)
        }
    }

    private fun checkResults(tickets: List<LottoTicket>, winningNumbers: List<Int>, bonusNumber: Int): List<Rank> {
        return tickets.map { ticket ->
            val matchCount = ticket.numbers.count { it in winningNumbers }
            val bonusMatched = ticket.numbers.contains(bonusNumber)
            Rank.from(matchCount, bonusMatched)
        }
    }

    private fun printStatistics(results: List<Rank>, amount: Int) {
        println("\nWinning Statistics")
        println("---")
        val rankCounts = Rank.entries.associateWith { rank -> results.count { it == rank } }

        println("3 Matches (5,000 KRW) – ${rankCounts[Rank.FIFTH]} tickets")
        println("4 Matches (50,000 KRW) – ${rankCounts[Rank.FOURTH]} tickets")
        println("5 Matches (1,500,000 KRW) – ${rankCounts[Rank.THIRD]} tickets")
        println("5 Matches + Bonus Ball (30,000,000 KRW) – ${rankCounts[Rank.SECOND]} tickets")
        println("6 Matches (2,000,000,000 KRW) – ${rankCounts[Rank.FIRST]} tickets")

        val totalPrize = results.sumOf { it.prize }
        val profitRate = totalPrize.toDouble() / amount * 100
        println("Total return rate is ${String.format("%.1f", profitRate)}%.")

    }
}

data class LottoTicket(val numbers: List<Int>)

enum class Rank(val matchCount: Int, val bonusMatch: Boolean = false, val prize: Int) {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    MISS(0, false, 0);

    companion object {
        fun from(matchCount: Int, bonusMatched: Boolean): Rank = when {
            matchCount == 6 -> FIRST
            matchCount == 5 && bonusMatched -> SECOND
            matchCount == 5 -> THIRD
            matchCount == 4 -> FOURTH
            matchCount == 3 -> FIFTH
            else -> MISS
        }
    }
}
