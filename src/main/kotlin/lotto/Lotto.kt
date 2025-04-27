package lotto

class Lotto(private val numbers: List<Int>) {
    private val sortedNumbers: List<Int>

    init {
        require(numbers.size == REQUIRED_COUNT) { NUMBER_COUNTER_ERROR_MESSAGE }
        require(numbers.distinct().size == REQUIRED_COUNT) { NUMBER_UNIQUE_ERROR_MESSAGE }
        require(numbers.all { it in LOWER_RANGE..UPPER_RANGE }) { NUMBER_RANGE_ERROR_MESSAGE }
        sortedNumbers = numbers.sorted()
    }

    override fun toString(): String {
        return sortedNumbers.toString()
    }

    companion object {
        private const val NUMBER_COUNTER_ERROR_MESSAGE = "Lotto must contain exactly 6 numbers."
        private const val NUMBER_UNIQUE_ERROR_MESSAGE = "Lotto numbers must be unique."
        private const val NUMBER_RANGE_ERROR_MESSAGE = "Lotto numbers must be between 1 and 45."
        private const val REQUIRED_COUNT = 6
        private const val LOWER_RANGE = 1
        private const val UPPER_RANGE = 45
    }

}
