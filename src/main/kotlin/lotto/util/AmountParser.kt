package lotto.util

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
        if (amount % 1000 != 0) throw IllegalArgumentException("[ERROR] Purchase amount must be divisible by $TICKET_PRICE.")
    }

    companion object{
        private const val TICKET_PRICE = 1000
    }
}