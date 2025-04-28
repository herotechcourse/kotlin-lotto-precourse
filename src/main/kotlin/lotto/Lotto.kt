package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { Constants.ERROR_LOTTO_SIZE }
        require(numbers.all { it in 1..45 }) { Constants.ERROR_LOTTO_RANGE }
        require(numbers.toSet().size == 6) { Constants.ERROR_LOTTO_DUPLICATE }
    }

    fun getNumbers(): List<Int> {
        return numbers
    }

    fun countMatch(winningNumbers: List<Int>): Int {
        return numbers.count { it in winningNumbers }
    }

    fun hasBonus(bonusNumber: Int): Boolean {
        return bonusNumber in numbers
    }

    override fun toString(): String {
        return numbers.joinToString(
            separator = Constants.LOTTO_DELIMITER,
            prefix = Constants.LOTTO_PREFIX,
            postfix = Constants.LOTTO_POSTFIX
        )
    }
}
