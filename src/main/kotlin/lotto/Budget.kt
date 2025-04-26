package lotto

data class Budget(private val amount: Int) {
    init {
        require(amount % 1000 == 0) { "The purchase amount must be divisible by 1,000." }
    }

    fun ticketCounts(): Int {
        return amount / 1000
    }
}
