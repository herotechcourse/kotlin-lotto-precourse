package lotto.domain

class BonusNumber(number: Int) {
    init {
        require(number > 0) { ErrorMessages.NOT_A_POSITIVE_NUMBER_ERROR }
        require(number in LottoConstants.MIN_LOTTO_NUMBER..LottoConstants.MAX_LOTTO_NUMBER) {
            ErrorMessages.LOTTO_NUMBER_RANGE_ERROR
        }
    }

    companion object {
        fun from(input: String): BonusNumber {
            require(input.isNotBlank()) { ErrorMessages.BLANK_ERROR }

            val parsedInput =
                input.toIntOrNull() ?: throw IllegalArgumentException(ErrorMessages.NOT_A_NUMBER_ERROR)

            return BonusNumber(parsedInput)
        }
    }
}