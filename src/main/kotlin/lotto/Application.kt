package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    // TODO: Implement the program

    // Get Purchase amount/ Show tickets / Run Ticket Machine
    val inputView = InputView()
    val outputView = OutputView()
    val ticketMachine = TicketMachine()

    // Input purchase amount
    val purchaseAmount = inputView.inputPurchaseAmount()


    // Generate tickets
    val tickets = ticketMachine.generateTickets(purchaseAmount)
    outputView.displayTickets(tickets)
    // Input winning numbers and bonus number
    val winningNumbers = inputView.inputWinningNumbers()
    val bonusNumber = inputView.inputBonusNumber(winningNumbers)

    // Calculate prizes
    val prizeCounts = ticketMachine.calculatePrizes(tickets, winningNumbers, bonusNumber)

    // Calculate profit rate
    val profitRate = ticketMachine.calculateProfitRate(purchaseAmount, prizeCounts)

    // Display results
    outputView.displayResults(prizeCounts, profitRate)
}


class TicketMachine {
    private val ticketPrice = 1000

    // Define prize amounts
    private val prizeAmounts = mapOf(
        3 to 5_000L,
        4 to 50_000L,
        5 to 1_500_000L,
        5 to 30_000_000L,  // 5 matches + bonus
        6 to 2_000_000_000L

    )

    // Function to generate tickets
    fun generateTickets(purchaseAmount: Int): List<Lotto> {
        if (purchaseAmount % ticketPrice != 0) {
            throw IllegalArgumentException("[ERROR] Purchase amount must be divisible by 1,000 KRW.")
        }

        val ticketCount = purchaseAmount / ticketPrice
        val tickets = mutableListOf<Lotto>()

        repeat(ticketCount) {
            val ticketNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted()
            tickets.add(Lotto(ticketNumbers))
        }

        return tickets
    }

    // Function to calculate the prizes based on matching tickets
    fun calculatePrizes(tickets: List<Lotto>, winningNumbers: List<Int>, bonusNumber: Int): Map<String, Int> {
        val prizeCounts = mutableMapOf(
            "3 Matches (5,000 KRW)" to 0,
            "4 Matches (50,000 KRW)" to 0,
            "5 Matches (1,500,000 KRW)" to 0,
            "5 Matches + Bonus Ball (30,000,000 KRW)" to 0,
            "6 Matches (2,000,000,000 KRW)" to 0
        )
        tickets.forEach { ticket ->
            val matchingNumbers = ticket.getNumbers().intersect(winningNumbers)
            val matchCount = matchingNumbers.size
            val hasBonus = bonusNumber in ticket.getNumbers()

            when {
                matchCount == 3 -> prizeCounts["3 Matches (5,000 KRW)"] = prizeCounts.getOrDefault("3 Matches (5,000 KRW)", 0) + 1
                matchCount == 4 -> prizeCounts["4 Matches (50,000 KRW)"] = prizeCounts.getOrDefault("4 Matches (50,000 KRW)", 0) + 1
                matchCount == 5 && hasBonus -> prizeCounts["5 Matches + Bonus Ball (30,000,000 KRW)"] = prizeCounts.getOrDefault("5 Matches + Bonus Ball (30,000,000 KRW)", 0) + 1
                matchCount == 5 -> prizeCounts["5 Matches (1,500,000 KRW)"] = prizeCounts.getOrDefault("5 Matches (1,500,000 KRW)", 0) + 1
                matchCount == 6 -> prizeCounts["6 Matches (2,000,000,000 KRW)"] = prizeCounts.getOrDefault("6 Matches (2,000,000,000 KRW)", 0) + 1

            }
        }

        // Ensure all prize categories are present, even with zero tickets
        val prizeKeys = listOf(
            "3 Matches (5,000 KRW)",
            "4 Matches (50,000 KRW)",
            "5 Matches (1,500,000 KRW)",
            "5 Matches + Bonus Ball (30,000,000 KRW)",
            "6 Matches (2,000,000,000 KRW)"
        )

        prizeKeys.forEach { prizeKey ->
            prizeCounts.putIfAbsent(prizeKey, 0)
        }

        return prizeCounts
    }

    // Calculate the profit rate
    fun calculateProfitRate(purchaseAmount: Int, prizeCounts: Map<String, Int>): Double {
        val totalPrize = prizeCounts.entries.sumOf { (prize, count) ->
            when (prize) {
                "3 Matches (5,000 KRW)" -> count * 5_000
                "4 Matches (50,000 KRW)" -> count * 50_000
                "5 Matches (1,500,000 KRW)" -> count * 1_500_000
                "5 Matches + Bonus Ball (30,000,000 KRW)" -> count * 30_000_000
                "6 Matches (2,000,000,000 KRW)" -> count * 2_000_000_000
                else -> 0
            }
        }

        return (totalPrize.toDouble() / purchaseAmount) * 100
    }
}

class InputView {
    fun inputPurchaseAmount(): Int {
        while (true) {
            try {
                println("Purchase amount for lottery tickets:")
                val input = Console.readLine().toInt()
                if (input % 1000 != 0) throw IllegalArgumentException("[ERROR] Purchase amount must be divisible by 1,000 KRW.")
                return input
            } catch (e: IllegalArgumentException) {
                println("[ERROR] Please enter a valid number for the purchase amount.")
            }
        }
    }

    fun inputWinningNumbers(): List<Int> {
        while (true) {
            try {
                println("Winning numbers (comma-separated):")
                val input = Console.readLine().split(",").map { it.trim().toInt() }
                if (input.size != 6 || input.toSet().size != 6 || input.any { it !in 1..45 }) {
                    throw IllegalArgumentException("[ERROR] Winning numbers must be 6 unique numbers between 1 and 45.")
                }
                return input.sorted()
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    fun inputBonusNumber(winningNumbers: List<Int>): Int {
        while (true) {
            try {
                println("Bonus number:")
                val input = Console.readLine().toInt()
                require(input !in winningNumbers) { "[ERROR] Bonus number must not be one of the winning numbers." }
                if (input !in 1..45) {
                    throw IllegalArgumentException("[ERROR] Bonus number must be between 1 and 45.")
                }
                return input
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }
}

class OutputView {
    fun displayTickets(tickets: List<Lotto>) {

        println("You have purchased ${tickets.size} tickets.")
        tickets.forEach { println(it.getNumbers()) }
    }

    fun displayResults(prizeCounts: Map<String, Int>, profitRate: Double) {

        prizeCounts.forEach { (prize, count) ->
            println("$prize – $count tickets")
        }


        println("Total return rate is %.1f%%.".format(profitRate))
    }
}