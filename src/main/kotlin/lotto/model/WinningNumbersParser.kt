package lotto.model

object WinningNumbersParser {
    fun parse(winningNumbers: String): List<String> {
        val parsedWinningNumbers: List<String> = winningNumbers.split(",").toList().map { it -> it.trim() }

        return parsedWinningNumbers
    }
}