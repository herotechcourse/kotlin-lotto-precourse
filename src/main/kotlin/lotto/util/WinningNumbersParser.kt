package lotto.util

class WinningNumbersParser {
    fun parse(input: String): List<Int> {
        val winningNumbers = parseInputToList(input)

        validateWinningNumbers(winningNumbers)

        return winningNumbers

    }

    private fun parseInputToList(input: String): List<Int> {
        val trimmedInput = input.filter { !it.isWhitespace() }

        val winningNumbers = try {
            trimmedInput.split(",").map { it.toInt() }
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("[ERROR] Winning numbers must contain only numeric values.")
        }

        validateInput(trimmedInput)

        return winningNumbers
    }

    private fun validateInput(input: String) {
        if (input.isEmpty()) throw IllegalArgumentException("[ERROR] Winning numbers can't be empty.")

        if (input.contains(" ") && !input.contains(",")) throw IllegalArgumentException("[ERROR] Winning numbers must be separated by ',' not spaces.")

    }

    private fun validateWinningNumbers(winningNumbers: List<Int>) {
        val uniqueWinningNumbers = mutableSetOf<Int>()

        if (winningNumbers.size != WINNING_NUMBERS_LENGTH) throw IllegalArgumentException("[ERROR] Winning numbers must contain exactly $WINNING_NUMBERS_LENGTH digits.")

        winningNumbers.forEach { winningNumber ->
            if (!uniqueWinningNumbers.add(winningNumber)) throw IllegalArgumentException(
                "[ERROR] Duplicated winning number : $winningNumber"
            )
            if (winningNumber < MIN_WINNING_NUMBER || winningNumber > MAX_WINNING_NUMBERS) throw IllegalArgumentException(
                "[ERROR] Winning numbers must be within $MIN_WINNING_NUMBER - $MAX_WINNING_NUMBERS range."
            )
        }
    }

    companion object {
        const val WINNING_NUMBERS_LENGTH = 6
        const val MIN_WINNING_NUMBER = 1
        const val MAX_WINNING_NUMBERS = 45
    }
}