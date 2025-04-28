package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    // TODO: Implement the program
    try {
        val purchaseAmount = readPurchaseAmount()
        val lottoTickets = buyLottoTickets(purchaseAmount)
        printLottoTickets(lottoTickets)

        val winningNumbers = readWinningNumbers()
        val bonusNumber = readBonusNumber(winningNumbers)
        val results = calculateResults(lottoTickets, winningNumbers, bonusNumber)
        printResults(results, purchaseAmount)
    } catch (e: IllegalArgumentException) {
        println(e.message)
    }
}
// Converting input into an Integer
fun readPurchaseAmount(): Int {
    println("Please enter the purchase amount.")
    val amount = Console.readLine().toIntOrNull()
        ?: throw IllegalArgumentException("[ERROR] Please enter a valid number.")
    if (amount < 1000 || amount % 1000 != 0) {
        throw IllegalArgumentException("[ERROR] Amount must be a multiple of 1000.")
    }
    return amount
}
fun buyLottoTickets(amount: Int): List<Lotto> {
    val count = amount / 1000
    return List(count) { Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6))}
}

fun printLottoTickets(lottos: List<Lotto>) {
    println("You have purchased ${lottos.size} tickets.")
    lottos.forEach { println(it.getSortedNumbers()) }
}
fun readWinningNumbers(): List<Int> {
    println("Please enter last week's winning numbers.")
    val input = Console.readLine()
    val numbers = input.split(",").mapNotNull { it.trim().toIntOrNull() }
    if (numbers.size != 6 || numbers.toSet().size != 6) {
        throw IllegalArgumentException("[ERROR] You must input exactly 6 unique numbers.")
    }
    if (numbers.any { it !in 1..45 }) {
        throw IllegalArgumentException("[ERROR] Numbers must be between 1 and 45.")
    }
    return numbers
}

fun readBonusNumber(winningNumbers: List<Int>): Int {
    println("Please enter the bonus number.")
    val bonus = Console.readLine().toIntOrNull()
        ?: throw IllegalArgumentException("[ERROR] Please enter a valid number.")
    if (bonus in winningNumbers) {
        throw IllegalArgumentException("[ERROR] Bonus number must not be among winning numbers.")
    }
    if (bonus !in 1..45) {
        throw IllegalArgumentException("[ERROR] Bonus number must be between 1 and 45.")
    }
    return bonus
}
fun calculateResults(lottos: List<Lotto>, winningNumbers: List<Int>, bonusNumber: Int): Map<Rank, Int> {
    val result = mutableMapOf<Rank, Int>()
    lottos.forEach { lotto ->
        val matchCount = lotto.matchCount(winningNumbers)
        val bonusMatched = lotto.containsBonus(bonusNumber)
        val rank = Rank.of(matchCount, bonusMatched)
        result[rank] = result.getOrDefault(rank, 0) + 1
    }
    return result
}
// Print result statistics
fun printResults(result: Map<Rank, Int>, purchaseAmount: Int) {
    println("\nWinning Statistics")
    println("---")
    Rank.values().filter { it != Rank.MISS }.forEach { rank ->
        val label = if (rank.requiresBonus) "${rank.matchCount} Matches + Bonus Ball" else "${rank.matchCount} Matches"
        val count = result.getOrDefault(rank, 0)
        val ticketLabel = if (count == 1) "ticket" else "tickets"
        println("$label (${rank.prize} KRW) – $count $ticketLabel")
    }
    val totalPrize = result.entries.sumOf { (rank, count) -> rank.prize * count }
    val profitRate = totalPrize.toDouble() / purchaseAmount * 100
    println("Total return rate is ${"%.1f".format(profitRate)}%.")
}
enum class Rank(val matchCount: Int, val prize: Int, val requiresBonus: Boolean = false){
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000, true),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    companion object {
        fun of(matchCount: Int, bonus: Boolean): Rank {
            return when {
                matchCount == 6 -> FIRST
                matchCount == 5 && bonus -> SECOND
                matchCount == 5 -> THIRD
                matchCount == 4 -> FOURTH
                matchCount == 3 -> FIFTH
                else -> MISS
            }
        }
    }
}