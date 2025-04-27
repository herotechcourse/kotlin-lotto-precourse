package lotto

import lotto.Consts.LOTTO_NUMBER_SIZE

interface LottoValidator : Validator {

    fun validateNumbers(numbers: List<Int>) {
        numbers.forEach {
            validateInRange(it)
        }
        validateSize(numbers.size)
        validateDuplicatedNumber(numbers)
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