package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] Lotto must contain exactly 6 numbers." }
        require(numbers.toSet().size == 6) { "[ERROR] Lotto must contain unique 6 numbers." }
        require(numbers.all { it in 1..45 }) { "[ERROR] Each Lotto number must be between 1 and 45." }
    }

    fun getNumbers(): List<Int> {
        return numbers.toList()
    }

    fun countMatches(targetLotto: Lotto): Int {
        return numbers.count { targetLotto.containsNumber(it) }
    }

    fun containsNumber(targetNumber: Int): Boolean {
        return targetNumber in numbers
    }
}
