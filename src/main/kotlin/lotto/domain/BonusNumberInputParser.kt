package lotto.domain

class BonusNumberInputParser {
    fun parse(input: String): BonusNumber {
        require(input.toIntOrNull() != null) { BONUS_NUMBER_MUST_BE_INTEGER }
        return BonusNumber(input.toInt())
    }

    companion object {
        const val BONUS_NUMBER_MUST_BE_INTEGER = "[ERROR] Bonus number must be an integer."
    }
}