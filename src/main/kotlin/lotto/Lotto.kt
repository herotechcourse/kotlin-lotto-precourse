package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] Lotto must contain exactly 6 numbers." }
        require(numbers.toSet().size == 6) { "[ERROR] Lotto numbers must be unique." }
        require(numbers.all { it in 1..45 }) { "[ERROR] Lotto numbers must be in range 1-45." }
    }

    fun getNumbers(): List<Int> {
        return numbers
    }

    fun displayTicket() {
        println(numbers)
    }

    fun contains(number: Int): Boolean {
        return number in numbers
    }

    fun matchCount(winningNumbers: List<Int>): Int {
        return numbers.count { it in winningNumbers }
    }
}
