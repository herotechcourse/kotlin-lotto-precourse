package lotto.domain

class WinningNumber(private val numbers: List<Int>) {
    // Validates the user input for last week lotto winning numbers
    init {
        require(numbers.size == REQUIRED_SIZE) {
            "[ERROR] Winning numbers must consist of exactly $REQUIRED_SIZE numbers."
        }
        require(numbers.toSet().size == REQUIRED_SIZE) {
            "[ERROR] Winning numbers must be unique."
        }
        require(numbers.all { it in MIN_NUMBER..MAX_NUMBER }) {
            "[ERROR] Winning numbers must be between $MIN_NUMBER and $MAX_NUMBER."
        }
    }

    /*
     * Returns a copy of the winning number list so users can access it safely
     * Protects the original list from being accidentally changed.
     * numbers is declared as private
     */
    fun getNumbers(): List<Int> = numbers.toList()

    companion object {
        private const val REQUIRED_SIZE = 6
        private const val MIN_NUMBER = 1
        private const val MAX_NUMBER = 45
    }
}
