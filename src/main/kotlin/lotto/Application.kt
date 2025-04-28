package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    val amount = readPurchaseAmount()
    val tickets = generateTickets(amount)
    println("\nYou have purchased ${tickets.size} tickets:")
    for (ticket in tickets) {
        println(ticket.getNumbers())
    }

    val winningNumbers = readWinningNumbers()
    val bonusNumber = readBonusNumber()

    println("\nWinning Numbers: $winningNumbers")
    println("Bonus Number: $bonusNumber")

    println("\nWinning Statistics")
    println("---")
    val rankCount = mutableMapOf<Rank, Int>()

    for (ticket in tickets) {
        val rank = determineRank(ticket.getNumbers(), winningNumbers, bonusNumber)
        rankCount[rank] = rankCount.getOrDefault(rank, 0) + 1
    }

    for (rank in listOf(Rank.FIFTH, Rank.FOURTH, Rank.THIRD, Rank.SECOND, Rank.FIRST)) {
        println("${rank.matchCount} Matches${if (rank == Rank.SECOND) " + Bonus Ball" else ""} (${ "%,d".format(rank.prize) } KRW) – ${rankCount.getOrDefault(rank, 0)} tickets")
    }

    calculateProfitRate(rankCount, amount)
}

fun readPurchaseAmount(): Int {
    println("Please enter the purchase amount:")

    while (true) {
        val input = Console.readLine()
        val amount = input.toIntOrNull()

        if (amount == null) {
            println("[ERROR] Input must be a valid integer.")
            continue
        }

        if (amount <= 0 || amount % 1000 != 0) {
            println("[ERROR] Amount must be a positive number divisible by 1,000.")
            continue
        }

        return amount
    }
}

fun generateTickets(amount: Int): List<Lotto> {
    val ticketCount = amount / 1000
    val tickets = mutableListOf<Lotto>()

    repeat(ticketCount) {
        val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted()
        tickets.add(Lotto(numbers))
    }
    return tickets
}


fun readWinningNumbers(): List<Int> {
    println("\nPlease enter last week's winning numbers (comma-separated):")

    val input = Console.readLine()
    val numbers = input.split(",")
        .map { it.trim().toIntOrNull() ?: throw IllegalArgumentException("[ERROR] Winning numbers must be valid integers") }

    if (numbers.size != 6) {
        throw IllegalArgumentException("[ERROR] Exactly 6 winning numbers are required")
    }
    if (numbers.distinct().size != numbers.size) {
        throw IllegalArgumentException("[ERROR] Winning numbers must be unique")
    }
    if (numbers.any { it !in 1..45 }) {
        throw IllegalArgumentException("[ERROR] Winning numbers must be between 1 and 45")
    }

    return numbers.sorted()
}

fun readBonusNumber(): Int {
    println("\nPlease enter the bonus number:")

    val input = Console.readLine()
    val number = input.toIntOrNull()
        ?: throw IllegalArgumentException("[ERROR] Bonus number must be a valid integer")

    if (number !in 1..45) {
        throw IllegalArgumentException("[ERROR] Bonus number must be between 1 and 45")
    }

    return number
}

fun determineRank(ticket: List<Int>, winningNumbers: List<Int>, bonusNumber: Int): Rank {
    val matchCount = ticket.count { it in winningNumbers }
    val bonusMatch = bonusNumber in ticket

    return Rank.from(matchCount, bonusMatch)
}

fun calculateProfitRate(rankCount: Map<Rank, Int>, totalSpent: Int) {
    val totalPrizeMoney = rankCount.entries.sumOf { (rank, count) ->
        rank.prize.toLong() * count
    }
    val profitRate = totalPrizeMoney.toDouble() / totalSpent * 100

    println("Total return rate is ${"%.1f".format(profitRate)}%.")
}
