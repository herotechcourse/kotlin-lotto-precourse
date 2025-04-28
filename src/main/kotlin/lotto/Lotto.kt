package lotto
import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == LOTTO_SIZE) { "[ERROR] Lotto must contain exactly 6 numbers." }
        require(numbers.toSet().size == LOTTO_SIZE) { "[ERROR] Lotto numbers must be unique." }
        require(numbers.all { it in LOTTO_MIN_NUMBER..LOTTO_MAX_NUMBER }) { "[ERROR] Lotto numbers must be between 1 and 45." }
    }

    companion object {
        private const val LOTTO_SIZE = 6
        private const val LOTTO_MIN_NUMBER = 1
        private const val LOTTO_MAX_NUMBER = 45
    }

    // Returns a copy of the lotto numbers to prevent external modification
    fun getNumbers(): List<Int> = numbers.toList()
}

// Reads the purchase amount from the user
fun readPurchaseAmount(): Int {
    println("Please enter the purchase amount.")
    return Console.readLine().toIntOrNull()
        ?: throw IllegalArgumentException("[ERROR] Invalid input. Please enter a valid number.")
}

// Validates if the purchase amount is divisible by 1000
fun validateAmount(amount: Int) {
    if (amount % 1000 != 0) {
        throw IllegalArgumentException("[ERROR] Amount must be divisible by 1000.")
    }
}

fun generateTickets(amount: Int): List<Lotto> {
    val numberOfTickets = amount / 1000
    return List(numberOfTickets) {
        Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6))
    }
}

// Prints the generated lotto tickets
fun printTickets(tickets: List<Lotto>) {
    println("${tickets.size} tickets purchased.")
    tickets.forEach { println(it.getNumbers().sorted()) }
}

// Reads last week's winning numbers from the user
fun readWinningNumbers(): List<Int> {
    println("Please enter last week's winning numbers (comma-separated).")
    return Console.readLine()
        .split(",")
        .map { it.trim().toIntOrNull() ?: throw IllegalArgumentException("[ERROR] Invalid winning number input.") }
}

// Reads the bonus number from the user
fun readBonusNumber(): Int {
    println("Please enter the bonus number.")
    return Console.readLine().toIntOrNull()
        ?: throw IllegalArgumentException("[ERROR] Invalid bonus number input.")
}

// Manages the winning lotto numbers and the bonus number
class WinningNumbers(
    private val winningNumbers: Lotto,
    private val bonusNumber: Int
) {
    init {
        require(bonusNumber in 1..45) { "[ERROR] Bonus number must be between 1 and 45." }
        require(bonusNumber !in winningNumbers.getNumbers()) { "[ERROR] Bonus number must not duplicate winning numbers." }
    }

    // Counts how many numbers match between a ticket and the winning numbers
    fun countMatch(ticket: Lotto): Int {
        return ticket.getNumbers().count { it in winningNumbers.getNumbers() }
    }

    // Checks whether the ticket contains the bonus number
    fun isBonusMatched(ticket: Lotto): Boolean {
        return bonusNumber in ticket.getNumbers()
    }
}

// Calculates the number of tickets per prize rank
fun calculateResults(tickets: List<Lotto>, winningNumbers: WinningNumbers): Map<Int, Int> {
    val resultMap = mutableMapOf<Int, Int>()

    tickets.forEach { ticket ->
        val matchCount = winningNumbers.countMatch(ticket)
        val bonusMatched = winningNumbers.isBonusMatched(ticket)

        val rank = when {
            matchCount == 6 -> 1
            matchCount == 5 && bonusMatched -> 2
            matchCount == 5 -> 3
            matchCount == 4 -> 4
            matchCount == 3 -> 5
            else -> null
        }

        rank?.let {
            resultMap[it] = resultMap.getOrDefault(it, 0) + 1
        }
    }

    return resultMap
}

// Calculates the total return rate based on winnings and purchase amount
fun calculateTotalRate(results: Map<Int, Int>, totalAmount: Int): Double {
    val prizeMoney = mapOf(
        1 to 2_000_000_000,
        2 to 30_000_000,
        3 to 1_500_000,
        4 to 50_000,
        5 to 5_000
    )

    val totalWinnings = results.entries.sumOf { (rank, count) ->
        (prizeMoney[rank] ?: 0) * count
    }

    return (totalWinnings.toDouble() / totalAmount) * 100
}



