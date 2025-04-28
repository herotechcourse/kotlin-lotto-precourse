package lotto.exception

enum class InputException(private val message: String) {
    TAG("[ERROR]"),

    MUST_BE_NUMBER("${TAG.message} This input must be a number."),
    MUST_NOT_BE_BLANK("${TAG.message} This input must not be blank."),
    PLEASE_RE_TRY("Please enter again.");

    fun message(): String = message
}