package lotto

class Lotto(private val numbers: List<LottoNumber>) {

    init {
        require(numbers.size == LOTTO_SIZE) { LOTTO_SIZE_ERROR }
        require(numbers.toSet().size == numbers.size) { LOTTO_NUMBER_NOT_UNIQUE_ERROR }
    }

    fun countSameNumber(other: Lotto): Int {
        return numbers.count { other.hasSameNumber(it) }
    }

    fun doesNotContain(lottoNumber: LottoNumber): Boolean {
        return !hasSameNumber(lottoNumber)
    }

    fun hasSameNumber(lottoNumber: LottoNumber): Boolean {
        return numbers.contains(lottoNumber)
    }

    fun numbers(): List<LottoNumber> {
        return numbers.toList()
    }

    companion object {
        private const val LOTTO_SIZE: Int = 6

        private const val LOTTO_SIZE_ERROR: String = "[ERROR] Lotto must contain exactly $LOTTO_SIZE numbers."
        private const val LOTTO_NUMBER_NOT_UNIQUE_ERROR: String = "[ERROR] Each Lotto number should be unique."
    }
}
