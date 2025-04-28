package lotto

class LottoPurchaseAmount(val value: Int) {

    init {
        require(value in MIM_PURCHASE_AMOUNT..MAX_PURCHASE_AMOUNT) { PURCHASE_AMOUNT_ERROR }
        require(value % MIM_PURCHASE_AMOUNT == 0) { PURCHASE_AMOUNT_NOT_DIVISIBLE_ERROR }
    }

    companion object {
        private const val MIM_PURCHASE_AMOUNT: Int = 1_000
        private const val MAX_PURCHASE_AMOUNT: Int = 100_000

        private const val PURCHASE_AMOUNT_ERROR: String =
            "[ERROR] Purchase amount should be between $MIM_PURCHASE_AMOUNT and $MAX_PURCHASE_AMOUNT KRW."
        private const val PURCHASE_AMOUNT_NOT_DIVISIBLE_ERROR: String =
            "[ERROR] Purchase amount should be divisible by $MIM_PURCHASE_AMOUNT."
    }
}
