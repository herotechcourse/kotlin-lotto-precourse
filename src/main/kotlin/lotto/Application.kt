package lotto

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console
import java.util.Locale


class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] Lotto must contain exactly 6 numbers." }
    }

    fun getNumbers(): List<Int> = numbers

}

fun printInfo(ticketCount: Int) {
    var ending = ""
    if (ticketCount > 1)
        ending = "s"

    println("You have purchased $ticketCount ticket${ending}.")
}
fun main() {
    val purchaseAmount = readPurchaseAmount()
    val ticketCount = purchaseAmount / 1000

    printInfo(ticketCount)
    val tickets = generateTickets(ticketCount)
    printTickets(tickets)

    val winningNumbers = readWinningNumbers()
    val bonusNumber = readBonusNumber(winningNumbers)

    val ranks = tickets.map { getRank(it, winningNumbers, bonusNumber) }
//    val rankCount = countRanks(ranks)
    val winner = ranks.firstOrNull{ it != Rank.NONE } ?: Rank.NONE

    printResult(winner, purchaseAmount)
}

enum class Rank(val match: Int, val prize: Int) {
    NONE(0, 0),
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000),
    FIRST(6, 2_000_000_000),

}

fun determineRank(matchCount: Int, hasBonus: Boolean): Rank {
        if (matchCount == 6) return Rank.FIRST
        if (matchCount == 5 && hasBonus) return Rank.SECOND
        if (matchCount == 5) return Rank.THIRD
        if (matchCount == 4) return Rank.FOURTH
        if (matchCount == 3) return Rank.FIFTH
        return Rank.NONE
}

fun readPurchaseAmount(): Int {
    println("Enter the purchase amount:")
    val input = Console.readLine()
    val amount = input.toIntOrNull() ?: throw IllegalArgumentException("[ERROR] Invalid input. Enter a number.")
    if (amount % 1000 != 0) throw IllegalArgumentException("[ERROR] Amount must be a multiple of 1000.")
    return amount
}

fun generateTickets(count: Int): List<Lotto> {
    return List(count) {
        val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
        Lotto(numbers)
    }
}
fun printTickets(tickets: List<Lotto>) {
    tickets.forEach { println(it.getNumbers().sorted()) }
}

fun readWinningNumbers(): Set<Int> {
    while (true) {
        println("Enter 6 winning numbers separated by commas:")
        val input = Console.readLine()
        val numbers = input.split(",").mapNotNull { it.trim().toIntOrNull() }
        if (numbers.size == 6 && numbers.toSet().size == 6 && numbers.all { it in 1..45 }) {
            return numbers.toSet()
        }
    }
}

fun readBonusNumber(winningNumbers: Set<Int>): Int {
    while (true) {
        println("Enter the bonus number:")
        val input = Console.readLine()
        val number = input.toIntOrNull()
        if (number != null && number !in winningNumbers && number in 1..45) {
            return number
        }
    }
}

fun getRank(ticket: Lotto, winningNumbers: Set<Int>, bonus: Int): Rank {
    val matchCount = ticket.getNumbers().count { it in winningNumbers }
    val hasBonus = bonus in ticket.getNumbers()
    return determineRank(matchCount, hasBonus)
}

fun countRanks(ranks: List<Rank>): Map<Rank, Int> {
    return Rank.entries.associateWith { rank -> ranks.count { it == rank } }
}

fun boolToNum(value: Boolean): Int {
    if (value)
        return 1
    return 0
}
fun formatPrize(prize: Int, ): String {
    return String.format(Locale.US, "%,d", prize)
}

fun printResult(winner: Rank, amount: Int) {
    println("Winning Statistics")
    println("------------------")
    var bonus = ""
    if (winner.prize == Rank.SECOND.prize)
        bonus = "+ Bonus Ball "
    Rank.entries.filter { it != Rank.NONE }.forEach {
        println("${it.match} Matches ${bonus}(${formatPrize(it.prize)} KRW) - ${boolToNum(it == winner)} tickets")
    }
//    val totalWinnings = rankCount.entries.first { it.key != Rank.NONE && it.value == 1 }.key.prize
//    val rate = (totalWinnings.toDouble() * 100 / amount).toInt()
    val rate = (winner.prize.toDouble() * 100.0 / amount.toDouble())
    println("Total return rate: $rate%.")

    /*
    4000 - 100%
    won - x%

     */
}