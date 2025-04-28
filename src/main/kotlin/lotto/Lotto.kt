package lotto

import lotto.common.ErrorMessages
import lotto.common.LottoUtil

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.isNotEmpty()) { ErrorMessages.INVALID_LOTTO_NUMBERS_TYPE }
        require(LottoUtil.isValidLottoSize(numbers)) { ErrorMessages.INVALID_LOTTO_NUMBERS_SIZE }
        require(numbers.all { LottoUtil.isValidLottoNumber(it) }) { ErrorMessages.INVALID_LOTTO_NUMBERS_UNIT }
        require(numbers.size == numbers.toSet().size) { ErrorMessages.INVALID_LOTTO_NUMBERS_ITEM }
    }

    fun getNumbers(): List<Int> = numbers.toList()

    fun contains(number: Int) = number in numbers
}
