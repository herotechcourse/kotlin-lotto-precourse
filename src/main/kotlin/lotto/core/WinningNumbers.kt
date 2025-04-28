package lotto.core

import lotto.core.constant.ErrorMessage.ErrorMessages.LOTTO_NUMBER_SIZE_ERROR
import lotto.core.constant.ErrorMessage.ErrorMessages.LOTTO_UNIQUE_NUMBER_ERROR
import lotto.core.constant.ErrorMessage.ErrorMessages.LOTTO_WINING_NUMBER_RANGE_ERROR
import lotto.core.constant.LottoConstants.LOTTO_NUMBER_SIZE
import lotto.core.constant.LottoConstants.MAX_LOTTO_NUMBER
import lotto.core.constant.LottoConstants.MIN_LOTTO_NUMBER

data class WinningNumbers(private val numbers: List<Int>) {
    init {
        require(numbers.size == LOTTO_NUMBER_SIZE) { LOTTO_NUMBER_SIZE_ERROR }
        require(numbers.distinct().size == LOTTO_NUMBER_SIZE) { LOTTO_UNIQUE_NUMBER_ERROR }
        require(numbers.all { it in MIN_LOTTO_NUMBER..MAX_LOTTO_NUMBER }) { LOTTO_WINING_NUMBER_RANGE_ERROR }
    }

    fun getNumbers(): List<Int> = numbers.sorted()
}