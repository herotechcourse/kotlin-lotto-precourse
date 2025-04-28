package lotto.domain

class WinningNumbers(private val numbers: List<Int>) {
    init {
        require(numbers.size == VALID_SIZE) { "[ERROR] Winning numbers must contain exactly $VALID_SIZE numbers." }
        require(numbers.size == numbers.distinct().size) { "[ERROR] Winning Numbers must not be duplicated." }
    }

    companion object {
        private const val VALID_SIZE = 6
    }
}