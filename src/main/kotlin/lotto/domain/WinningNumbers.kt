package lotto.domain

class WinningNumbers(val numbers: List<Int>) {
    companion object {
        fun from(winningNumbers: List<String>): WinningNumbers {
            var parsedWinningNumbers = winningNumbers.map {
                require(it.isNotBlank()) { BLANK_ERROR }

                it.toInt()
            }

            return WinningNumbers(parsedWinningNumbers)
        }

        private const val BLANK_ERROR: String = "Winning number must not be blank"
    }
}