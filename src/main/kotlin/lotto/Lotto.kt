package lotto

import lotto.domain.LottoConstants

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == LottoConstants.LOTTO_NUMBER_SIZE) { LOTTO_NUMBER_SIZE_ERROR }
    }

    companion object {
        private const val LOTTO_NUMBER_SIZE_ERROR: String = "Lotto must contain exactly 6 numbers."
    }
}
