package lotto

class PurchaseAmount(private val amount: Int) {

    init {
        require(amount > 0) { "[ERR] The Purchase amount must be positive. Please enter again." }
        require(amount >= Lotto.PRICE) { "[ERR] The purchase amount must be greater than or equal to the single lottery ticket price(${String.format("%,d",Lotto.PRICE)}${Lotto.CURRENCY}). Please enter again."}
    }

    fun toInt(): Int {
        return amount
    }
}
