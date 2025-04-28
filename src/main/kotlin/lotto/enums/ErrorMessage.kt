package lotto.enums

enum class ErrorMessage(val message: String) {
    ERR_EMPTY_INPUT("Empty input is not allowed."),
    ERR_IS_NOT_DIGIT_STRING("Input must consist of numbers only."),
    ERR_INVALID_NUMBER_RANGE("Number is out of valid range."),
    ERR_IS_NOT_INTEGER_RANGE("Input is not a valid integer."),
    ERR_IS_NOT_DIVISIABLE_INPUT("Input is not divisible."),
    ERR_IS_NOT_SAME_WITH_LIST_SIZE("Invalid number of arguments."),
    ERR_IS_DUPLICATED("Duplicate elements are not allowed.")
}
