package lotto.domain

class PurchaseAmount(val amount: Int) {
    init {
        require(amount > 0) { ErrorMessages.NOT_A_POSITIVE_NUMBER_ERROR }
        require(amount % LottoConstants.LOTTO_PRICE == 0) { NOT_DIVISIBLE_BY_1000_ERROR }
    }

    val possibleLottoTicketCount: Int
        get() = amount / LottoConstants.LOTTO_PRICE

    companion object {
        fun from(input: String): PurchaseAmount {
            require(input.isNotBlank()) { ErrorMessages.BLANK_ERROR }

            val parsedInput =
                input.toIntOrNull() ?: throw IllegalArgumentException(ErrorMessages.NOT_A_NUMBER_ERROR)

            return PurchaseAmount(parsedInput)
        }

        private const val NOT_DIVISIBLE_BY_1000_ERROR: String = "Purchase Amount must be divisible by 1,000"
    }
}