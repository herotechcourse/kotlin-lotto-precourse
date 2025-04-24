package lotto

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
            "$ERROR_PREFIX Lotto number '$number' must be between $START_NUMBER and $END_NUMBER."
        }
    }

    private fun validateSize(size: Int) {
        require(size == LOTTO_NUMBER_SIZE) {
            "$ERROR_PREFIX Lotto number's size '$size' must be 6."
        }
    }

    private fun validateDuplicatedNumber(numbers: List<Int>) {
        require(numbers.distinct().size == numbers.size) {
            "$ERROR_PREFIX Lotto number must not contain duplicated numbers."
        }
    }

    companion object {
        private const val ERROR_PREFIX = "[ERROR]"
        private const val LOTTO_NUMBER_SIZE = 6
        private const val START_NUMBER = 1
        private const val END_NUMBER = 45
    }
}