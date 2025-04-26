package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
        LottoGame().run()
}

class LottoGame {
    private val ticketPrice = 1000
    private val tickets = mutableListOf<Lotto>()

    fun run() {
        val purchaseAmount = getValidPurchaseAmount()
        generateTickets(purchaseAmount / ticketPrice)
        printTickets()

        val winningNumbers = getValidWinningNumbers()
        val bonusNumber = getValidBonusNumber(winningNumbers)

        val results = calculateResults(winningNumbers, bonusNumber)
        printResults(results)
    }

    private fun getValidPurchaseAmount(): Int {
        while (true) {
            println("Please enter the purchase amount.")
            try {
                val input = Console.readLine().toInt()
                require(input % ticketPrice == 0) { "[ERROR] Purchase amount must be divisible by 1000." }
                return input
            } catch (e: NumberFormatException) {
                println("[ERROR] Please enter a valid number.")
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    private fun generateTickets(count: Int) {
        repeat(count) {
            val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
            tickets.add(Lotto(numbers))
        }
    }

    private fun printTickets() {
        println("You have purchased ${tickets.size} tickets.")
        tickets.sortedWith(Comparator { a, b ->
            val aNums = a.getNumbers()
            val bNums = b.getNumbers()
            for (i in aNums.indices) {
                val cmp = aNums[i].compareTo(bNums[i])
                if (cmp != 0) return@Comparator cmp
            }
            0
        }).forEach { println(it) }
    }

    private fun getValidWinningNumbers(): List<Int> {
        while (true) {
            println("\nPlease enter last week's winning numbers.")
            try {
                val input = Console.readLine().split(",").map { it.trim().toInt() }
                require(input.size == 6) { "[ERROR] Please enter exactly 6 numbers." }
                require(input.distinct().size == 6) { "[ERROR] Numbers must be unique." }
                require(input.all { it in 1..45 }) { "[ERROR] Numbers must be between 1 and 45." }
                return input.sorted()
            } catch (e: NumberFormatException) {
                println("[ERROR] Please enter valid numbers.")
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    private fun getValidBonusNumber(winningNumbers: List<Int>): Int {
        while (true) {
            println("\nPlease enter the bonus number.")
            try {
                val input = Console.readLine().toInt()
                require(input in 1..45) { "[ERROR] Bonus number must be between 1 and 45." }
                require(input !in winningNumbers) { "[ERROR] Bonus number must not be in winning numbers." }
                return input
            } catch (e: NumberFormatException) {
                println("[ERROR] Please enter a valid number.")
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    private fun calculateResults(winningNumbers: List<Int>, bonusNumber: Int): Map<Rank, Int> {
        val results = mutableMapOf<Rank, Int>().withDefault { 0 }

        tickets.forEach { ticket ->
            val matchCount = ticket.countMatchingNumbers(winningNumbers)
            val hasBonus = ticket.contains(bonusNumber)
            val rank = Rank.valueOf(matchCount, hasBonus)
            if (rank != Rank.NONE) {
                results[rank] = results.getValue(rank) + 1
            }
        }

        return results
    }

    private fun printResults(results: Map<Rank, Int>) {
        val totalPrize = results.entries.sumOf { (rank, count) -> rank.prize * count }
        val purchaseAmount = tickets.size * ticketPrice
        val profitRate = (totalPrize.toDouble() / purchaseAmount) * 100

        println("\nLotto result statistics:")
        println("---")
        Rank.values().filter { it != Rank.NONE }.reversed().forEach { rank ->
            val prizeFormatted = "%,d".format(rank.prize)
            val count = results[rank] ?: 0
            val ticketWord = if (count == 1) "ticket" else "tickets"
            val label = if (rank.hasBonus) " + Bonus Ball" else ""
            println("${rank.matchCount} Matches$label (${prizeFormatted} KRW) - $count $ticketWord")
        }
        println("Total return rate is ${"%.1f".format(profitRate)}%.")
    }
}
