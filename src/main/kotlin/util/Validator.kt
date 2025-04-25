package util

object Validator {
    private val NUMERIC = Regex("^[0-9]+$")
    private val COMMA_SEPARATED = Regex("^[^,]+(,[^,]+)*$")
    private val COMMA_SEPARATED_NUMBERS = Regex("^[0-9]+(,[0-9]+)*$")

    fun checkNumberFormat(input: String) {
        require(input.matches(NUMERIC)) { "[ERROR] Input must be a valid number." }
    }

    fun checkNumbersFormat(input: String) {
        require(input.matches(COMMA_SEPARATED)) { "[ERROR] Input must be comma-separated." }
        require(input.matches(COMMA_SEPARATED_NUMBERS)) { "[ERROR] Input must be comma-separated numbers." }
    }

    fun checkPurchaseAmountRules(value: Int) {
        require(value > 0) { "[ERROR] Purchase amount must be greater than 0." }
        require(value % 1000 == 0) { "[ERROR] Purchase amount must be a multiple of 1000." }
    }

    fun checkLottoNumberRules(value: Int) {
        require(value > 0) { "[ERROR] Lotto number must be greater than 0." }
        require(value in 1..45) { "[ERROR] Lotto number must be between 1 and 45." }
    }

    fun checkLottoNumbersRules(value: List<Int>) {
        require(value.size == 6) { "[ERROR] Lotto numbers must contain exactly 6 numbers." }
        require(value.toSet().size == 6) { "[ERROR] Lotto numbers must not contain duplicates." }
        value.forEach { checkLottoNumberRules(it) }
    }
}
