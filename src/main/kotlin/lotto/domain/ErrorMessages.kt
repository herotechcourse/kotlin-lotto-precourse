package lotto.domain

object ErrorMessages {
    const val BLANK_ERROR: String = "Must not be blank"
    const val NOT_A_NUMBER_ERROR: String = "Must be a number"
    const val NOT_A_POSITIVE_NUMBER_ERROR: String = "Must be a positive number"
    const val LOTTO_NUMBER_SIZE_ERROR: String = "Lotto must contain exactly 6 numbers."
    const val LOTTO_DUPLICATED_NUMBER_ERROR: String = "Lotto numbers must not be duplicated."
    const val LOTTO_NUMBER_RANGE_ERROR: String = "Lotto range must be between 1 and 45."
}