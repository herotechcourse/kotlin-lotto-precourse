package lotto

/**
 *  [ Background ]
 *  (1) Reason to use "private"
 *      1. numbers
 *      Given format from <Woowahan-pjs> already defines private.
 *      = To guarantee immutability. (Not let outside change it)
 *
 *      2. validate()
 *      = Only used inside when creating Lotto object.
 *
 *      3. companion object constants
 *      = They are only needed inside Lotto.
 *
 *  (2) Reason to use "const"
 *      = In Kotlin, only simple type like numbers and strings can use "const".
 *        Using "const" helps save memory and makes the program run slightly faster.
 *        "LOTTO_NUMBER_RANGE" is an object(IntRange), so it can't use "const".
 */
class Lotto(private val numbers: List<Int>) {
    init {
        validate(numbers)
    }

    private fun validate(numbers: List<Int>) {
        require(numbers.size == LOTTO_NUMBER_COUNT) { ERROR_INVALID_SIZE_MESSAGE }
        require(numbers.toSet().size == LOTTO_NUMBER_COUNT) { ERROR_DUPLICATE_NUMBERS_MESSAGE }
        require(numbers.all { it in LOTTO_NUMBER_RANGE }) { ERROR_INVALID_NUMBER_RANGE_MESSAGE }
    }

    fun getNumbers(): List<Int> = numbers.toList()

    fun countMatchedNumbers(winningNumbers: List<Int>): Int {
        return numbers.count { it in winningNumbers }
    }

    fun isBonusNumber(bonusNumber: Int): Boolean {
        return numbers.contains(bonusNumber)
    }

    companion object {
        private const val LOTTO_NUMBER_COUNT = 6
        private val LOTTO_NUMBER_RANGE = 1..45
        private const val ERROR_INVALID_SIZE_MESSAGE = "[ERROR] Lotto must contain exactly 6 numbers."
        private const val ERROR_DUPLICATE_NUMBERS_MESSAGE = "[ERROR] Lotto numbers must be unique."
        private const val ERROR_INVALID_NUMBER_RANGE_MESSAGE = "[ERROR] Lotto numbers must be between 1 and 45."
    }
}