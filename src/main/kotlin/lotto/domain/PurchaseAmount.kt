package lotto.domain

class PurchaseAmount(private val amount: Int) {

    init {
        validate(amount)
    }

    private fun validate(amount: Int) {
        require(amount >= MIN_AMOUNT) { ERROR_MINIMUM_AMOUNT }
        require(amount % UNIT == 0) { ERROR_AMOUNT_UNIT }
    }

    fun countPurchasableLottos(): Int {
        return amount / UNIT
    }

    fun value(): Int {
        return amount
    }

    companion object {
        private const val UNIT = 1000
        private const val MIN_AMOUNT = 1000
        private const val ERROR_MINIMUM_AMOUNT = "[ERROR] Amount must be at least 1,000."
        private const val ERROR_AMOUNT_UNIT = "[ERROR] Amount must be divisible by 1,000."
    }
}