package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] Lotto must contain exactly 6 numbers." }
    }

    fun getNumbers(): List<Int> = numbers.sorted()

    fun countMatching(winningNumbers: List<Int>): Int {
        return numbers.count { it in winningNumbers }
    }

    fun contains(number: Int): Boolean {
        return number in numbers
    }

}
