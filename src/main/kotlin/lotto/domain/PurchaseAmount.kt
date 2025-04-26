package lotto.domain

class PurchaseAmount(private val amount: Int) {

    init {
        require(amount > 0) { "amount should" }
        require(amount % 1000 == 0) { "" }
    }

    fun toInt(): Int {
        return amount
    }
}
