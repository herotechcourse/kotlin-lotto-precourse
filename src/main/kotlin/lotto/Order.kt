package lotto

class Order(private val amount: Int) {
    init {
        require(amount > 0) { Configuration.ErrorMessages.PURCHASE_AMOUNT_NON_ZERO }
        require(amount % Configuration.LOTTO_PRICE == 0) { "${Configuration.ErrorMessages.PURCHASE_AMOUNT_DIVISIBLE} ${Configuration.LOTTO_PRICE}." }
    }

    fun getLottoCount(): Int {
        return amount / Configuration.LOTTO_PRICE
    }

    fun getPurchaseAmount(): Int {
        return amount
    }
}