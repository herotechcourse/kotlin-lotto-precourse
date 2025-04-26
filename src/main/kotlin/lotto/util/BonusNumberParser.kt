package lotto.util

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
        if (bonusNumber < MIN_BONUS_NUMBER || bonusNumber > MAX_BONUS_NUMBER) throw IllegalArgumentException("[ERROR] Bonus number must be between $MIN_BONUS_NUMBER and $MAX_BONUS_NUMBER.")

        if (winningNumbers.contains(bonusNumber)) throw IllegalArgumentException("[ERROR] Bonus number must not be one of the winning number.")
    }

    companion object {
        private const val MIN_BONUS_NUMBER = 1
        private const val MAX_BONUS_NUMBER = 45
    }
}