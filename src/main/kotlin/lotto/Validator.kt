package lotto

object Validator {

    fun validatePurchaseAmount(input: String): Int {
        val number = input.toIntOrNull() ?:
            throw IllegalArgumentException(Messages.ERROR_INVALID_NUMBER)
        if (number < 0)
            throw IllegalArgumentException(Messages.ERROR_NEGATIVE_NUMBER)
        if (number % LottoConstants.TICKET_PRICE !=  0)
            throw IllegalArgumentException(Messages.ERROR_NOT_THOUSANDS)
        return number
    }

    fun validateWinningNumbers(input: String): List<Int> {
        val winnerNumbers = parseWinningNumbers((input))
        if (winnerNumbers.size != 6) {
            throw IllegalArgumentException(Messages.ERROR_NOT_SIX_NUMBERS)
        }
        if (winnerNumbers.distinct().size != winnerNumbers.size) {
            throw IllegalArgumentException(Messages.ERROR_NOT_UNIQUE)
        }
        if (winnerNumbers.any { it !in 1..45 }) {
            throw IllegalArgumentException(Messages.ERROR_OUT_OF_RANGE)
        }
        return winnerNumbers
    }

    private fun parseWinningNumbers(input: String): List<Int> {
        return input
            .split(",")
            .map { it.trim() }
            .map {
                it.toIntOrNull() ?: throw IllegalArgumentException(
                    Messages.ERROR_INVALID_NUMBER)
            }
    }
}