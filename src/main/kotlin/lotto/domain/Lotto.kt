package lotto

class Lotto(private val numbers: List<Int>) {

    init {
        require(numbers.size == VALID_NUMBER_COUNT) { ERROR_INVALID_NUMBER_COUNT }
        require(numbers.distinct().size == VALID_NUMBER_COUNT) { ERROR_DUPLICATE_NUMBERS }
        require(numbers.all { it in MIN_LOTTO_NUMBER..MAX_LOTTO_NUMBER }) { ERROR_NOT_IN_RANGE }
    }

    companion object {
        const val VALID_NUMBER_COUNT = 6
        const val MIN_LOTTO_NUMBER = 1
        const val MAX_LOTTO_NUMBER = 45

        const val ERROR_INVALID_NUMBER_COUNT = "[ERROR] Lotto must contain exactly $VALID_NUMBER_COUNT numbers."
        const val ERROR_DUPLICATE_NUMBERS = "[ERROR] Numbers must not contain duplicates."
        const val ERROR_NOT_IN_RANGE = "[ERROR] Lotto numbers must be between $MIN_LOTTO_NUMBER and $MAX_LOTTO_NUMBER."
        const val ERROR_INPUT_EMPTY = "[ERROR] Input can not be empty."
        const val ERROR_NOT_VALID_NUMBER = "[ERROR] Input must be valid numbers."
    }

    //fun getNumbers(): List<Int> = numbers.sorted()

}