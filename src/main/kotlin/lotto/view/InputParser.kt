package lotto.view

private const val WINNING_NUMBERS_DELIMITER = ","

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

    fun parseWinningNumbers(input: String): List<Int> {
        return input.split(WINNING_NUMBERS_DELIMITER)
            .map { it.trim() }
            .map { toInt(it) }
    }
}
