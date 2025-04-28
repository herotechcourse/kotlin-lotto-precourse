package lotto.domain

class WinningNumbers(val numbers: List<Int>) {
    companion object {
        fun from(winningNumbers: List<String>): WinningNumbers {
            var parsedWinningNumbers = winningNumbers.map { it.toInt() }

            return WinningNumbers(parsedWinningNumbers)
        }
    }
}