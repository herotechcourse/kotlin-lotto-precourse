package lotto.util

import lotto.LotteryConstants

class AmountParser {
    fun parse(input: String): Int {
        validateInput(input)

        val parsedInput = try {
            input.trim().toInt()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("[ERROR] Purchase amount must be a numeric value.")
        }

        validateAmount(parsedInput)

        return parsedInput
    }

    private fun validateInput(input: String) {
        if (input.isEmpty()) throw IllegalArgumentException("[ERROR] Purchase amount must not be empty.")

        if (input.trim() != input) throw IllegalArgumentException("[ERROR] Purchase amount must not contain leading or trailing whitespace.")

    }

    private fun validateAmount(amount: Int) {
        if (amount <= 0) throw IllegalArgumentException("[ERROR] Purchase amount must be greater than zero.")
        if (amount % LotteryConstants.TICKET_PRIZE != 0) throw IllegalArgumentException("[ERROR] Purchase amount must be divisible by ${LotteryConstants.TICKET_PRIZE}.")
    }
}