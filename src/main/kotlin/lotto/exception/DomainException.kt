package lotto.exception

enum class DomainException(private val message: String) {
    TAG("[ERROR]"),

    AMOUNT_MUST_NOT_EXCEED("${TAG.message} Purchase amount must not exceed %d."),
    AMOUNT_MUST_ENTERED_AS("${TAG.message} Purchase amount must entered as %d."),

    MUST_CONTAIN("${TAG.message} Numbers must contain exactly %d numbers."),
    MUST_NOT_BE_DUPLICATED("${TAG.message} Numbers must not be duplicated."),
    MUST_BE_VALID_RANGE("${TAG.message} Numbers must be between %d and %d."),

    BONUS_NUMBER_IS_UNIQUE("${TAG.message} bonus number must not be duplicated with winning numbers.");

    fun format(vararg args: Any): String {
        return message.format(*args)
    }

    fun message() = message
}