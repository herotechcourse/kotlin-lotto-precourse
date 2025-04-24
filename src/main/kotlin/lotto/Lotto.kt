package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] Lotto must contain exactly 6 numbers." }
        require(numbers.size == numbers.toSet().size) { "[ERROR] Lotto numbers must be unique." }
        for (i in numbers) {
            if (i !in WINNING_NUMBER_RANGE_MIN..WINNING_NUMBER_RANGE_MAX) throw IllegalArgumentException("[ERROR]Lotto numbers must be between 1 and 45.")
        }
    }
    // TODO: Implement additional functions
}
