package util

object Parser {
    fun toPurchaseAmount(input: String): Int {
        Validator.checkNumberFormat(input)
        val value = input.toInt()
        Validator.checkPurchaseAmountRules(value)

        return value
    }

    fun toWinningNumbers(input: String): List<Int> {
        Validator.checkNumbersFormat(input)
        val value = input.split(",").map { it.toInt() }
        Validator.checkLottoNumbersRules(value)

        return value
    }

    fun toBonusNumber(input: String, winningNumbers: List<Int>): Int {
        Validator.checkNumberFormat(input)
        val value = input.toInt()
        Validator.checkBonusNumberRules(value, winningNumbers)

        return value
    }
}
