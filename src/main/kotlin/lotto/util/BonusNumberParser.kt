package lotto.util

import lotto.LotteryConstants

class BonusNumberParser {
    fun parse(input: String, winningNumbers: List<Int>): Int {
        validateInput(input)

        val parsedInput = try {
            input.trim().toInt()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("[ERROR] Bonus number must be a numeric value.")
        }

        validateBonusNumber(parsedInput, winningNumbers)

        return parsedInput

    }

    private fun validateInput(input: String) {
        if (input.isEmpty()) throw IllegalArgumentException("[ERROR] Bonus number must not be empty.")

        if (input.trim() != input) throw IllegalArgumentException("[ERROR] Bonus number must not contain leading or trailing whitespace.")

    }

    private fun validateBonusNumber(bonusNumber: Int, winningNumbers: List<Int>) {
        if (bonusNumber < LotteryConstants.MIN_NUMBER || bonusNumber > LotteryConstants.MAX_NUMBER) throw IllegalArgumentException(
            "[ERROR] Bonus number must be between ${LotteryConstants.MIN_NUMBER} and ${LotteryConstants.MAX_NUMBER} range."
        )

        if (winningNumbers.contains(bonusNumber)) throw IllegalArgumentException("[ERROR] Bonus number must not be one of the winning number.")
    }
}