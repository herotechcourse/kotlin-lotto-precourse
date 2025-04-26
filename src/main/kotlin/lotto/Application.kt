package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    try {
        val tickets = purchaseTickets()
        val winningNumbers = inputWinningNumbers()
        val bonusNumber = inputBonusNumber(winningNumbers)
        
        printTickets(tickets)
        calculateResults(tickets, winningNumbers, bonusNumber)
    } catch (e: IllegalArgumentException) {
        println(e.message)
    }
}

private fun purchaseTickets(): List<Lotto> {
    println("Please enter the purchase amount.")
    val amount = validatePurchaseAmount(Console.readLine())
    val ticketCount = amount / 1000
    return generateTickets(ticketCount)
}

private fun validatePurchaseAmount(input: String): Int {
    val amount = input.toIntOrNull() ?: throw IllegalArgumentException("[ERROR] Please enter a valid number for the purchase amount.")
    require(amount >= 1000) { "[ERROR] Purchase amount must be at least 1,000 KRW." }
    require(amount % 1000 == 0) { "[ERROR] Purchase amount must be divisible by 1,000 KRW." }
    return amount
}

private fun generateTickets(count: Int): List<Lotto> {
    return List(count) {
        val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted()
        Lotto(numbers)
    }
}

private fun inputWinningNumbers(): List<Int> {
    println("\nPlease enter the winning numbers (comma-separated):")
    val input = Console.readLine()
    val numbers = input.split(",").map { it.trim().toIntOrNull() 
        ?: throw IllegalArgumentException("[ERROR] Please enter valid numbers.") }
    
    require(numbers.size == 6) { "[ERROR] Exactly 6 winning numbers are required." }
    require(numbers.all { it in 1..45 }) { "[ERROR] Numbers must be between 1 and 45." }
    require(numbers.distinct().size == 6) { "[ERROR] Numbers must be unique." }
    
    return numbers.sorted()
}

private fun inputBonusNumber(winningNumbers: List<Int>): Int {
    println("\nPlease enter the bonus number:")
    val bonus = Console.readLine().toIntOrNull() 
        ?: throw IllegalArgumentException("[ERROR] Please enter a valid bonus number.")
    
    require(bonus in 1..45) { "[ERROR] Bonus number must be between 1 and 45." }
    require(bonus !in winningNumbers) { "[ERROR] Bonus number must not be in winning numbers." }
    
    return bonus
}

private fun printTickets(tickets: List<Lotto>) {
    println("\nYou have purchased ${tickets.size} tickets.")
    tickets.forEach { println(it.getNumbers()) }
}

private fun calculateResults(tickets: List<Lotto>, winningNumbers: List<Int>, bonusNumber: Int) {
    val results = mutableMapOf<Rank, Int>().withDefault { 0 }
    
    tickets.forEach { ticket ->
        val matchCount = ticket.countMatchingNumbers(winningNumbers)
        val hasBonus = ticket.hasBonusNumber(bonusNumber)
        val rank = Rank.valueOf(matchCount, hasBonus)
        results[rank] = results.getValue(rank) + 1
    }
    
    printResults(results)
    printProfitRate(results, tickets.size)
}

private fun printResults(results: Map<Rank, Int>) {
    println("\nWinning Statistics")
    println("---")
    Rank.entries.reversed().forEach { rank ->
        if (rank != Rank.NONE) {
            val bonusText = if (rank == Rank.SECOND) " + Bonus Ball" else ""
            println("${rank.matchCount} Matches${bonusText} (${rank.prize.withCommas()} KRW) - ${results.getValue(rank)} tickets")
        }
    }
}

private fun printProfitRate(results: Map<Rank, Int>, ticketCount: Int) {
    val totalPrize = results.entries.sumOf { (rank, count) -> rank.prize * count }
    val profitRate = (totalPrize.toDouble() / (ticketCount * 1000)) * 100
    println("Total return rate is ${"%.1f".format(profitRate)}%.")
}

private fun Int.withCommas(): String {
    return "%,d".format(this)
}

enum class Rank(val matchCount: Int, val hasBonus: Boolean, val prize: Int) {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    NONE(0, false, 0);
    
    companion object {
        fun valueOf(matchCount: Int, hasBonus: Boolean): Rank {
            return when {
                matchCount == 6 -> FIRST
                matchCount == 5 && hasBonus -> SECOND
                matchCount == 5 -> THIRD
                matchCount == 4 -> FOURTH
                matchCount == 3 -> FIFTH
                else -> NONE
            }
        }
    }
}