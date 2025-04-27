package lotto

class Order(private val amount: Int) {
    init {
        require(amount > 0) { throw IllegalArgumentException("[ERROR] Purchase amount must be greater than 0.") }
        require(amount % LOTTO_PRICE == 0) { throw IllegalArgumentException("[ERROR] Purchase amount must be a multiple of $LOTTO_PRICE.") }
    }

    fun getLottoCount(): Int {
        return amount / LOTTO_PRICE
    }

    fun getPurchaseAmount(): Int {
        return amount
    }
}