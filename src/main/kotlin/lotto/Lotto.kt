package lotto

class Lotto(private val numbers: List<Int>) {

    init {
        require(numbers.size == LOTTO_SIZE) { LOTTO_SIZE_ERROR }
        require(numbers.toSet().size == numbers.size) { LOTTO_NUMBER_NOT_UNIQUE_ERROR }
        require(numbers.all { it in MIN_RANGE..MAX_RANGE }) { NUMBER_OUT_OF_RANGE_ERROR }
    }

    fun countSameNumber(other: Lotto): Int {
        return numbers.count { other.hasSameNumber(it) }
    }

    fun doesNotContain(lottoNumber: Int): Boolean {
        return !hasSameNumber(lottoNumber)
    }

    fun hasSameNumber(lottoNumber: Int): Boolean {
        return numbers.contains(lottoNumber)
    }

    fun numbers(): List<Int> {
        return numbers.toList()
    }

    companion object {
        private const val LOTTO_SIZE: Int = 6
        private const val MIN_RANGE: Int = 1
        private const val MAX_RANGE: Int = 45

        private const val LOTTO_SIZE_ERROR: String = "[ERROR] Lotto must contain exactly $LOTTO_SIZE numbers."
        private const val LOTTO_NUMBER_NOT_UNIQUE_ERROR: String = "[ERROR] Each Lotto number should be unique."
        private const val NUMBER_OUT_OF_RANGE_ERROR: String =
            "[ERROR] Number must be between $MIN_RANGE and $MAX_RANGE."
    }
}
