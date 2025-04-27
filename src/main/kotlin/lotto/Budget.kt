package lotto

data class Budget(val amount: Int) {
    init {
        require(amount % LOTTO_PRICE == 0) { "The purchase amount must be divisible by 1,000." }
    }

    fun ticketCounts(): Int {
        return amount / LOTTO_PRICE
    }

    companion object {
        private const val LOTTO_PRICE = 1000
    }
}
