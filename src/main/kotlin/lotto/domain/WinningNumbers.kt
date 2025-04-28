package lotto.domain

class WinningNumbers(val numbers: List<Int>) {
    init {
        require(numbers.size == LottoConstants.LOTTO_NUMBER_SIZE) { ErrorMessages.LOTTO_NUMBER_SIZE_ERROR }
        require(numbers.toSet().size == LottoConstants.LOTTO_NUMBER_SIZE) { ErrorMessages.LOTTO_DUPLICATED_NUMBER_ERROR }

        numbers.forEach {
            require(it > 0) { ErrorMessages.NOT_A_POSITIVE_NUMBER_ERROR }
        }
    }

    companion object {
        fun from(winningNumbers: List<String>): WinningNumbers {
            var parsedWinningNumbers = winningNumbers.map {
                require(it.isNotBlank()) { ErrorMessages.BLANK_ERROR }

                val parsedWinningNumber =
                    it.toIntOrNull() ?: throw IllegalArgumentException(ErrorMessages.NOT_A_NUMBER_ERROR)

                parsedWinningNumber
            }

            return WinningNumbers(parsedWinningNumbers)
        }
    }
}