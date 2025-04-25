package lotto

class Lotto(private val numbers: List<Number>) {
    init {
        require(numbers.size == LOTTO_SIZE) { LOTTO_SIZE_ERROR }
        require(numbers.toSet().size == numbers.size) { LOTTO_NUMBER_NOT_UNIQUE_ERROR }
    }

    fun getMatchingCount(winningLotto: Lotto): Int {
        return numbers().count { winningLotto.hasSameNumber(it) }
    }

    fun hasBonusNumber(bonusNumber: Number): Boolean {
        return hasSameNumber(bonusNumber)
    }

    fun hasNotSameNumber(number: Number): Boolean {
        return !hasSameNumber(number)
    }

    private fun hasSameNumber(number: Number): Boolean {
        return numbers.contains(number)
    }

    fun numbers(): List<Number> {
        return numbers
    }

    companion object {
        private const val LOTTO_SIZE: Int = 6

        private const val LOTTO_SIZE_ERROR: String = "[ERROR] Lotto must contain exactly $LOTTO_SIZE numbers."
        private const val LOTTO_NUMBER_NOT_UNIQUE_ERROR: String = "[ERROR] Each Lotto number should be unique."
    }
}
