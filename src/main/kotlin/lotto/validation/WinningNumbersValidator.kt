package lotto.validation

object WinningNumbersValidator {
    private const val ERROR_PREFIX: String = "[ERROR]"
    private const val PROMPT_AGAIN: String = "Please enter it again"

    private const val EMPTY_INPUT = "$ERROR_PREFIX There is no input. $PROMPT_AGAIN"
    private const val NOT_SIX_NUMBERS = "$ERROR_PREFIX Winning numbers  must be 6 numbers. $PROMPT_AGAIN"
    private const val NOT_NUMBER_TYPE = "$ERROR_PREFIX Winning numbers must be a number. $PROMPT_AGAIN"

    fun validate(winningNumbers: List<String>) {
        if (winningNumbers.isEmpty()) {
            throw IllegalArgumentException(EMPTY_INPUT)
        }

        if (winningNumbers.size != 6) {
            throw IllegalArgumentException(NOT_SIX_NUMBERS)
        }

        val digitRegex = Regex("\\d+")
        if (!(winningNumbers.all { it.matches(digitRegex)})) {
            throw IllegalArgumentException(NOT_NUMBER_TYPE)
        }
    }
}