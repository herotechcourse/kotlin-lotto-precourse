package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == REQUIRED_SIZE) { ERROR_SIZE }
        require(numbers.toSet().size == REQUIRED_SIZE) { ERROR_DUPLICATE }
        require(numbers.all { it in MIN_NUMBER..MAX_NUMBER }) { ERROR_RANGE }
    }

    fun getNumbers(): List<Int> = numbers.toList()

    companion object {
        private const val REQUIRED_SIZE = 6
        private const val MIN_NUMBER = 1
        private const val MAX_NUMBER = 45

        private const val ERROR_SIZE = "[ERROR] Lotto must contain exactly $REQUIRED_SIZE numbers."
        private const val ERROR_DUPLICATE = "[ERROR] Lotto must contain $REQUIRED_SIZE unique numbers."
        private const val ERROR_RANGE = "[ERROR] Lotto numbers must be between $MIN_NUMBER and $MAX_NUMBER."
    }
}
