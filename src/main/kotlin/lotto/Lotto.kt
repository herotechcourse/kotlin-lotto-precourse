package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == Configuration.LOTTO_COUNT) { Configuration.ErrorMessages.LOTTO_COUNT_INVALID_SIZE }
        require(numbers.distinct().size == numbers.size) { Configuration.ErrorMessages.LOTTO_COUNT_INVALID_DUPLICATE }
        require(numbers.all { it in (Configuration.MIN_NUMBER)..(Configuration.MAX_NUMBER) }) { Configuration.ErrorMessages.LOTTO_COUNT_INVALID_RANGE }
    }

    fun getNumbers(): List<Int> {
        return numbers.sorted()
    }

    fun getMatchCount(winningNumbers: List<Int>): Int {
        return numbers.count { it in winningNumbers }
    }

    fun isBonusMatch(bonusNumber: Int): Boolean {
        return numbers.contains(bonusNumber)
    }
}
