package lotto

import camp.nextstep.edu.missionutils.Console

fun main() {
    try {
        val purchaseAmount = Console.readLine("Please enter the purchase amount.").toInt()
        val tickets = Lotto.generateTickets(purchaseAmount)
        tickets.forEach { println(it.numbers.sorted()) }

        val winningNumbers = Console.readLine("Please enter last week's winning numbers.").split(",").map { it.toInt() }
        val bonusNumber = Console.readLine("Please enter the bonus number.").toInt()

        val statistics = tickets.groupBy { it.matchingCount(winningNumbers, bonusNumber) }
        statistics.forEach { (matchCount, tickets) ->
            val prize = when (matchCount) {
                6 -> 2_000_000_000
                5 -> if (tickets.any { it.containsBonusNumber(winningNumbers, bonusNumber) }) 30_000_000 else 1_500_000
                4 -> 50_000
                3 -> 5_000
                else -> 0
            }
            println("$matchCount Matches (${prize} KRW) – ${tickets.size} tickets")
        }

        val totalWinnings = statistics.entries.sumOf { (matchCount, tickets) ->
            val prize = when (matchCount) {
                6 -> 2_000_000_000
                5 -> if (tickets.any { it.containsBonusNumber(winningNumbers, bonusNumber) }) 30_000_000 else 1_500_000
                4 -> 50_000
                3 -> 5_000
                else -> 0
            }
            prize * tickets.size
        }
        val profitRate = (totalWinnings.toDouble() / purchaseAmount) * 100
        println("Total return rate is %.1f%%.".format(profitRate))
    } catch (e: Exception) {
        println("[ERROR] Invalid input. Please try again.")
    }
}

private fun Lotto.matchingCount(winningNumbers: List<Int>, bonusNumber: Int): Int {
    val matchCount = numbers.count { it in winningNumbers }
    return when {
        matchCount == 5 && containsBonusNumber(winningNumbers, bonusNumber) -> 5
        matchCount == 6 -> 6
        else -> matchCount
    }
}

private fun Lotto.containsBonusNumber(winningNumbers: List<Int>, bonusNumber: Int): Boolean {
    return numbers.contains(bonusNumber) && numbers.none { it in winningNumbers }
}
