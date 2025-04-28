package lotto.validation

private const val ERROR_PREFIX: String = "[ERROR]"
private const val PROMPT_AGAIN: String = "Please enter it again."

enum class ErrorMessage(val message: String) {
    EMPTY_INPUT("$ERROR_PREFIX There is no input. $PROMPT_AGAIN"),
    NOT_NUMBER_TYPE("$ERROR_PREFIX Input must be a number. $PROMPT_AGAIN"),
}
