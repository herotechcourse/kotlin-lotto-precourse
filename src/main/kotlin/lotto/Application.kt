package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    try {
        val amount = readPurchaseAmount()
        val tickets = generateTickets(amount)
        printTickets(tickets)

        val winningNumbers = readWinningNumbers()
        val bonusNumber = readBonusNumber(winningNumbers)

        val result = analyzeResults(tickets, winningNumbers, bonusNumber)
        printStatistics(result, amount)
    } catch (e: IllegalArgumentException) {
        println(e.message)
    }
}

private fun readPurchaseAmount(): Int {
    println("Please enter the purchase amount.")
    val input = Console.readLine()
    val amount = input.toIntOrNull() ?: throw IllegalArgumentException("[ERROR] Input must be a number.")
    if (amount % 1000 != 0) throw IllegalArgumentException("[ERROR] Amount must be divisible by 1,000.")
    return amount
}

private fun generateTickets(amount: Int): List<Lotto> {
    val count = amount / 1000
    return List(count) {
        val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
        Lotto(numbers)
    }
}

private fun printTickets(tickets: List<Lotto>) {
    println("You have purchased ${tickets.size} tickets.")
    tickets.forEach { println(it) }
}

private fun readWinningNumbers(): List<Int> {
    println("Please enter last week's winning numbers.")
    val input = Console.readLine()
    val numbers = input.split(",").map {
        val num = it.trim().toIntOrNull() ?: throw IllegalArgumentException("[ERROR] Winning numbers must be integers.")
        if (num !in 1..45) throw IllegalArgumentException("[ERROR] Lotto numbers must be between 1 and 45.")
        num
    }
    if (numbers.size != 6 || numbers.toSet().size != 6)
        throw IllegalArgumentException("[ERROR] There must be exactly 6 unique winning numbers.")
    return numbers
}

private fun readBonusNumber(winningNumbers: List<Int>): Int {
    println("Please enter the bonus number.")
    val input = Console.readLine()
    val number = input.toIntOrNull() ?: throw IllegalArgumentException("[ERROR] Bonus number must be a number.")
    if (number !in 1..45) throw IllegalArgumentException("[ERROR] Lotto numbers must be between 1 and 45.")
    if (winningNumbers.contains(number)) throw IllegalArgumentException("[ERROR] Bonus number must not duplicate winning numbers.")
    return number
}

private fun analyzeResults(
    tickets: List<Lotto>,
    winning: List<Int>,
    bonus: Int
): Map<String, Int> {
    val results = mutableMapOf(
        "6" to 0,
        "5+bonus" to 0,
        "5" to 0,
        "4" to 0,
        "3" to 0
    )

    for (ticket in tickets) {
        val match = ticket.countMatching(winning)
        when {
            match == 6 -> results["6"] = results["6"]!! + 1
            match == 5 && ticket.contains(bonus) -> results["5+bonus"] = results["5+bonus"]!! + 1
            match == 5 -> results["5"] = results["5"]!! + 1
            match == 4 -> results["4"] = results["4"]!! + 1
            match == 3 -> results["3"] = results["3"]!! + 1
        }
    }

    return results
}

private fun printStatistics(result: Map<String, Int>, amount: Int) {
    println("Winning Statistics")
    println("---")
    val earnings = mapOf(
        "3" to 5_000,
        "4" to 50_000,
        "5" to 1_500_000,
        "5+bonus" to 30_000_000,
        "6" to 2_000_000_000
    )

    var totalReturn = 0
    earnings.forEach { (rank, prize) ->
        val count = result[rank] ?: 0
        println("${rankDescription(rank)} – $count tickets")
        totalReturn += prize * count
    }

    val rate = (totalReturn.toDouble() / amount * 1000).toInt() / 10.0
    println("Total return rate is ${rate}%.")
}

private fun rankDescription(rank: String): String {
    return when (rank) {
        "6" -> "6 Matches (2,000,000,000 KRW)"
        "5+bonus" -> "5 Matches + Bonus Ball (30,000,000 KRW)"
        "5" -> "5 Matches (1,500,000 KRW)"
        "4" -> "4 Matches (50,000 KRW)"
        "3" -> "3 Matches (5,000 KRW)"
        else -> ""
    }
}
