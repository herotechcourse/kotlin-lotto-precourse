package lotto.model

@JvmInline
value class LottoPurchaseAmount(
    private val amount: Int
) {
    init {
        require(amount >= LOTTO_PRICE) { "[ERROR] The minimum amount is $LOTTO_PRICE KRW." }
        require(amount % LOTTO_PRICE == 0) { "[ERROR] The amount must be in units of $LOTTO_PRICE KRW." }
    }

    fun toCount(): Int = amount / LOTTO_PRICE
}
