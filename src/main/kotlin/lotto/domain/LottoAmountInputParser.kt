package lotto.domain

class LottoAmountInputParser {
    fun parseToInt(input: String): Int{
        require(input.toIntOrNull() != null) {INVALID_INPUT}
        return input.toInt()
    }

    companion object {
        const val INVALID_INPUT = "[ERROR] Lotto Amount must be Integer"
    }
}