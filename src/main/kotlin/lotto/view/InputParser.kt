package lotto.view

class InputParser {
    fun parsePurchaseAmount(input: String): Int {
        val amount = toInt(input)
        require(amount > 0) { "Purchase amount must be a positive number." }
        return amount
    }

    private fun toInt(value: String): Int {
        try {
            return value.toInt()
        } catch (exception: NumberFormatException) {
            throw IllegalArgumentException("Input is not a number.")
        }
    }
}
