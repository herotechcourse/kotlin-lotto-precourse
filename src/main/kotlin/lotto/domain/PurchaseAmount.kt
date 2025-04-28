package lotto.domain

class PurchaseAmount(val amount: Int) {
    companion object {
        fun from(input: String): PurchaseAmount {
            require(input.isNotBlank()) { BLANK_ERROR }

            return PurchaseAmount(input.toInt())
        }

        private const val BLANK_ERROR: String = "[ERROR] Purchase Amount must not be blank"
    }
}