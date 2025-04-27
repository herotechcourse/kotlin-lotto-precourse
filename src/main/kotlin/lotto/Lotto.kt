package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == NUMBER_COUNT) { "Lotto must contain exactly 6 numbers." }
        require(numbers.toSet().size == NUMBER_COUNT) { "Lotto numbers must be unique." }
        require(numbers.all { it in MIN_NUMBER..MAX_NUMBER }) { "Lotto numbers must be in the range 1 to 45" }
    }

    fun contains(bonusNumber: Int): Boolean {
        return numbers.contains(bonusNumber)
    }

    fun match(other: Lotto): Int {
        return numbers.toSet().intersect(other.numbers.toSet()).size
    }

    fun getNumbers(): List<Int> {
        return numbers
    }

    companion object {
        private const val NUMBER_COUNT = 6
        private const val MIN_NUMBER = 1
        private const val MAX_NUMBER = 45
    }
}
