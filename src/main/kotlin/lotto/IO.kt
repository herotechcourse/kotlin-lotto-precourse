package lotto

import camp.nextstep.edu.missionutils.Console

class InputView {
    fun readPurchaseAmount(): Int {
        println("Please enter the purchase amount.")
        val amount =  readLineToInt()
        require(amount % 1000 == 0) { "[ERROR] Purchase amount must be divisible by 1,000." }
        return amount
    }

    fun readWinningNumbers(): List<Int> {
        println("\nPlease enter last week's winning numbers.")
        val input = readLineNotBlank()
        return parseNumbers(input, 6)
    }

    fun readBonusNumber(winningNumbers: List<Int>): Int {
        println("\nPlease enter the bonus number")
        val input = readLineNotBlank()
        val number = input.toIntOrNull() ?: throw IllegalArgumentException("[ERROR] Invalid bonus number.")
        require(number in 1..45) { "[ERROR] Bonus number must be in range (1-45)." }
        require(number !in winningNumbers) { "[ERROR] Bonus number cannot be one of the winning numbers." }
        return number
    }

    private fun readLineToInt(): Int =
        Console.readLine().toIntOrNull() ?: throw IllegalArgumentException("[ERROR] Invalid input.")

    private fun readLineNotBlank(): String =
        Console.readLine().trim().takeIf { it.trim().isNotEmpty() }
            ?: throw IllegalArgumentException("[ERROR] Input cannot be empty.")

    private fun parseNumbers(input: String, count: Int): List<Int> {
        val numbers = input.split(",")
            .map { it.trim().toIntOrNull() ?: throw IllegalArgumentException("[ERROR] Invalid number format.") }
        require(numbers.size == count) { "[ERROR] You should enter $count numbers." }
        require(numbers.all { it in 1..45 }) { "[ERROR] Numbers must be in the range 1..45." }
        require(numbers.distinct().size == count) { "[ERROR] Numbers must be unique." }
        return numbers
    }
}

class OutputView {
    fun displayPurchaseDetails(numberOfTickets: Int, tickets: List<Lotto>) {
        println("\nYou have purchased $numberOfTickets tickets.")
        tickets.forEach { println(it.getSortedNumbers()) }
    }

    fun displayResults(results: Map<LottoRank, Int>, profitRate: Double) {
        println("\nWinning Statistics")
        println("---")
        LottoRank.entries.filter { it.prize > 0 }.forEach { rank ->
            val count = results.getOrDefault(rank, 0)
            val bonusText = if (rank == LottoRank.SECOND) " + Bonus Ball" else ""
            val prizeFormatted = String.format("%,d", rank.prize)
            println("${rank.matchCount} Matches$bonusText (${prizeFormatted} KRW) – $count tickets")
        }
        println("Total return rate is ${String.format("%.1f", profitRate)}%.")
    }
}
