package lotto.util

object Validator {

    fun validatePurchaseAmount(input: String): Int {
        val number = input.toIntOrNull() ?: throw IllegalArgumentException(
            Messages.ERROR_INVALID_NUMBER
        )
        if (number < 0)
            throw IllegalArgumentException(Messages.ERROR_NEGATIVE_NUMBER)
        if (number % LottoConstants.TICKET_PRICE != 0)
            throw IllegalArgumentException(Messages.ERROR_NOT_THOUSANDS)
        return number
    }

    fun validateWinningNumbers(input: String): List<Int> {
        val winnerNumbers = parseWinningNumbers(input)
        validateNumbers(winnerNumbers)
        return winnerNumbers
    }

    private fun validateNumbers(numbers: List<Int>) {
        if (numbers.size != LottoConstants.NUMBERS_PER_TICKET) {
            throw IllegalArgumentException(Messages.ERROR_NOT_SIX_NUMBERS)
        }
        if (numbers.distinct().size != numbers.size) {
            throw IllegalArgumentException(Messages.ERROR_NOT_UNIQUE)
        }
        if (numbers.any { it !in LottoConstants.MIN_NUMBER..LottoConstants.MAX_NUMBER }) {
            throw IllegalArgumentException(Messages.ERROR_OUT_OF_RANGE)
        }
    }

    private fun parseWinningNumbers(input: String): List<Int> {
        return input
            .split(",")
            .map { it.trim() }
            .map {
                it.toIntOrNull() ?: throw IllegalArgumentException(
                    Messages.ERROR_INVALID_NUMBER
                )
            }
    }

    fun validateBonusNumber(input: String, winnerNumbers: List<Int>): Int {
        val number = parseBonusNumber(input)
        validateBonus(number, winnerNumbers)
        return number
    }

    private fun parseBonusNumber(input: String): Int {
        return input.toIntOrNull()
            ?: throw IllegalArgumentException(Messages.ERROR_INVALID_NUMBER)
    }

    private fun validateBonus(number: Int, winnerNumbers: List<Int>) {
        if (number !in LottoConstants.MIN_NUMBER..LottoConstants.MAX_NUMBER) {
            throw IllegalArgumentException(Messages.ERROR_OUT_OF_RANGE)
        }
        if (number in winnerNumbers) {
            throw IllegalArgumentException(Messages.ERROR_BONUS_IN_WINNER)
        }
    }
}