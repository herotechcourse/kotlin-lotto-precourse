package lotto.util

import lotto.LotteryConstants

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

        if (winningNumbers.size != LotteryConstants.LOTTO_NUMBER_COUNT) throw IllegalArgumentException(
            "[ERROR] Winning numbers must contain exactly ${LotteryConstants.LOTTO_NUMBER_COUNT} digits."
        )

        winningNumbers.forEach { winningNumber ->
            if (!uniqueWinningNumbers.add(winningNumber)) throw IllegalArgumentException(
                "[ERROR] Duplicated winning number : $winningNumber"
            )

            if (winningNumber < LotteryConstants.MIN_NUMBER || winningNumber > LotteryConstants.MAX_NUMBER) throw IllegalArgumentException(
                "[ERROR] Winning numbers must be within ${LotteryConstants.MIN_NUMBER} - ${LotteryConstants.MAX_NUMBER} range."
            )
        }
    }
}