package lotto

import lotto.utils.Constant.DUPLICATE_NUMBER_ERROR_MESSAGE
import lotto.utils.Constant.LOTTO_SIZE
import lotto.utils.Constant.LOTTO_SIZE_ERROR_MESSAGE

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == LOTTO_SIZE) { LOTTO_SIZE_ERROR_MESSAGE }
        require(numbers.toSet().size == numbers.size) { DUPLICATE_NUMBER_ERROR_MESSAGE }
    }

    fun getNumbers(): List<Int> = numbers
}
