package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == NUMBER_COUNT) { "[ERROR] Lotto must contain exactly $NUMBER_COUNT numbers." }
        require(numbers.toSet().size == NUMBER_COUNT) { "[ERROR] Duplicate numbers are not allowed." }
        require(numbers.all { it in MIN_NUMBER..MAX_NUMBER }) { "[ERROR] Numbers must be between $MIN_NUMBER and $MAX_NUMBER." }
    }

    override fun toString(): String {
        return numbers.toString()
    }

    fun getNumbers(): List<Int> {
        return numbers
    }

    companion object {
        const val NUMBER_COUNT = 6
        const val MIN_NUMBER = 1
        const val MAX_NUMBER = 45
    }
}
