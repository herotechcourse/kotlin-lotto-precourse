package util

object Validator {
    private const val ERROR_PREFIX = "[ERROR]"

    private val NUMERIC = Regex("^[0-9]+$")
    private val COMMA_SEPARATED = Regex("^[^,]+(,[^,]+)*$")
    private val COMMA_SEPARATED_NUMBERS = Regex("^[0-9]+(,[0-9]+)*$")

    /**
     * Validates that the input string contains only numeric characters (0-9).
     * Throws IllegalArgumentException if the input is not a valid number.
     */
    fun checkNumberFormat(input: String) {
        require(input.matches(NUMERIC)) { "$ERROR_PREFIX Input must be a valid number." }
    }

    /**
     * Validates that the input is a comma-separated list of numeric values.
     * - Ensures it follows general comma-separated format
     * - Ensures all elements are valid numbers
     */
    fun checkNumbersFormat(input: String) {
        require(input.matches(COMMA_SEPARATED)) { "$ERROR_PREFIX Input must be comma-separated." }
        require(input.matches(COMMA_SEPARATED_NUMBERS)) { "$ERROR_PREFIX Input must be comma-separated numbers." }
    }

    /**
     * Validates purchase amount rules:
     * - Must be greater than 0
     * - Must be a multiple of 1000
     */
    fun checkPurchaseAmountRules(value: Int) {
        require(value > 0) { "$ERROR_PREFIX Purchase amount must be greater than 0." }
        require(value % 1000 == 0) { "$ERROR_PREFIX Purchase amount must be a multiple of 1000." }
    }

    /**
     * Validates bonus number rules:
     * - Must not overlap with the winning numbers
     * - Must be between 1 and 45 (inclusive)
     */
    fun checkBonusNumberRules(value: Int, winningNumbers: List<Int>) {
        require(!winningNumbers.contains(value)) { "$ERROR_PREFIX Bonus number must not be in winning numbers." }
        checkLottoNumberRules(value)
    }

    /**
     * Validates individual lotto number:
     * - Must be greater than 0
     * - Must be in range 1 to 45 (inclusive)
     */
    fun checkLottoNumberRules(value: Int) {
        require(value > 0) { "$ERROR_PREFIX Lotto number must be greater than 0." }
        require(value in 1..45) { "$ERROR_PREFIX Lotto number must be between 1 and 45." }
    }

    /**
     * Validates a list of lotto numbers:
     * - Must contain exactly 6 numbers
     * - Must contain no duplicates
     * - Each number must be in range 1 to 45
     */
    fun checkLottoNumbersRules(value: List<Int>) {
        require(value.size == 6) { "$ERROR_PREFIX Lotto numbers must contain exactly 6 numbers." }
        require(value.toSet().size == 6) { "$ERROR_PREFIX Lotto numbers must not contain duplicates." }
        value.forEach { checkLottoNumberRules(it) }
    }
}
