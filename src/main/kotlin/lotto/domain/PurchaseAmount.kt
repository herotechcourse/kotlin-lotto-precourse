package lotto.domain

class PurchaseAmount(val amount: Int) {
    companion object {
        fun from(input: String): PurchaseAmount {
            require(input.isNotBlank()) { BLANK_ERROR }

            val parsedInput = input.toIntOrNull() ?: throw IllegalArgumentException(NOT_A_NUMBER_ERROR)

            return PurchaseAmount(parsedInput)
        }

        private const val BLANK_ERROR: String = "[ERROR] Purchase Amount must not be blank"
        private const val NOT_A_NUMBER_ERROR: String = "[ERROR] Purchase Amount must be a number"
    }
}