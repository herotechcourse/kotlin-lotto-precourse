package lotto


class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == LOTTO_NUMBER_COUNT) { ERROR_INVALID_SIZE }
        require(numbers.toSet().size == LOTTO_NUMBER_COUNT) { ERROR_DUPLICATE_NUMBER }
        require(numbers.all { it in LOTTO_NUMBER_MIN..LOTTO_NUMBER_MAX }) { ERROR_OUT_OF_RANGE }
    }

    fun getSortedNumbers(): List<Int> {
        return numbers.sorted()
    }

    fun countingWinningNumbers(winningNumbers: List<Int>): Int {
        return numbers.count { it in winningNumbers }
    }

    fun isContainsBonusNumber(bonusNumber: Int): Boolean {
        return bonusNumber in numbers
    }

    companion object {
        private const val ERROR_INVALID_SIZE = "$ERROR_PREFIX Lotto must contain exactly 6 numbers."
        private const val ERROR_DUPLICATE_NUMBER = "$ERROR_PREFIX Lotto numbers must be unique."
        private const val ERROR_OUT_OF_RANGE = "$ERROR_PREFIX Lotto numbers must be between 1 and 45."
    }
}