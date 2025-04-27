package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] Lotto must contain exactly 6 numbers." }
        require(numbers.size == numbers.toSet().size) {"[ERROR] All numbers must be unique"}
        require(numbers.all { it in 1..45 }) {"[ERROR] All numbers must be between 1 and 45"}
    }

    // TODO: Implement additional functions
    fun getTicketNumbers(): List<Int> {
        return sortNumbers()
    }

    fun getMatchingNumbers(winningNumbers: List<Int>): Int {
        return numbers.count{ it in winningNumbers}
    }

    private fun sortNumbers(): List<Int>{
        return numbers.sorted()
    }
}
