package lotto.domain

class WinningNumbers(val numbers: List<Int>) {
    init {
        numbers.forEach{
            require(it > 0) { NOT_A_POSITIVE_NUMBER_ERROR }
        }
    }

    companion object {
        fun from(winningNumbers: List<String>): WinningNumbers {
            var parsedWinningNumbers = winningNumbers.map {
                require(it.isNotBlank()) { BLANK_ERROR }

                val parsedWinningNumber = it.toIntOrNull() ?: throw IllegalArgumentException(NOT_A_NUMBER_ERROR)

                parsedWinningNumber
            }

            return WinningNumbers(parsedWinningNumbers)
        }

        private const val BLANK_ERROR: String = "Winning number must not be blank"
        private const val NOT_A_NUMBER_ERROR: String = "Winning number must be a number"
        private const val NOT_A_POSITIVE_NUMBER_ERROR: String = "Winning number must be a positive number"
    }
}