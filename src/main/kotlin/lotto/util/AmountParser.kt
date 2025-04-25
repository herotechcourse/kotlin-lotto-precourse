package lotto.util

class AmountParser {
    fun parse(input: String): Int {
        if (input.isEmpty()) throw IllegalArgumentException("[ERROR] Purchase amount must not be empty.")
        val parsedInput = try {
            input.toInt()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("[ERROR] Purchase amount must be a numeric value.")
        }

        validateAmount(parsedInput)

        return parsedInput
    }

    private fun validateAmount(amount: Int) {
        if (amount <= 0) throw IllegalArgumentException("[ERROR] Purchase amount must be greater than zero.")
        if (amount % 1000 != 0) throw IllegalArgumentException("[ERROR] Purchase amount must be divisible by 1,000.")
    }
}