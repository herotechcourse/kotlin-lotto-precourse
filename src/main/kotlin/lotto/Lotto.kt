package lotto

import lotto.domain.LottoConstants
import lotto.domain.Lottos

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == LottoConstants.LOTTO_NUMBER_SIZE) { LOTTO_NUMBER_SIZE_ERROR }

        numbers.forEach {
            require(it in LottoConstants.MIN_LOTTO_NUMBER..LottoConstants.MAX_LOTTO_NUMBER) {
                LOTTO_NUMBER_RANGE_ERROR
            }
        }
    }

    companion object {
        private const val LOTTO_NUMBER_SIZE_ERROR: String = "Lotto must contain exactly 6 numbers."
        private const val LOTTO_NUMBER_RANGE_ERROR: String = "Lotto range must be between 1 and 45."
    }
}
