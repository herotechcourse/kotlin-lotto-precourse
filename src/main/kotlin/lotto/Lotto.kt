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



