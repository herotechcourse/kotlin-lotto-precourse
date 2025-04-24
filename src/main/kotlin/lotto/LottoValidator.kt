package lotto

import lotto.Consts.END_NUMBER
import lotto.Consts.LOTTO_NUMBER_SIZE
import lotto.Consts.START_NUMBER

interface LottoValidator {

    fun validateNumbers(numbers: List<Int>) {
        numbers.forEach {
            validateInRange(it)
        }
        validateSize(numbers.size)
        validateDuplicatedNumber(numbers)
    }

    private fun validateInRange(number: Int) {
        require(number in START_NUMBER..END_NUMBER) {
            "Lotto number '$number' must be between $START_NUMBER and $END_NUMBER."
        }
    }

    private fun validateSize(size: Int) {
        require(size == LOTTO_NUMBER_SIZE) {
            "Lotto number's size '$size' must be 6."
        }
    }

    private fun validateDuplicatedNumber(numbers: List<Int>) {
        require(numbers.distinct().size == numbers.size) {
            "Lotto number must not contain duplicated numbers."
        }
    }
}