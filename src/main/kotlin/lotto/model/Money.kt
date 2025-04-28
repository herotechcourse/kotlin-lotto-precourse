package lotto.model

class Money(private val amount: Int) {

    // Validate that the amount is positive and a multiple of 1,000 upon creation
    init {
        require(amount > 0) { "[ERROR] Amount must be greater than 0." }
        require(amount % 1000 == 0) { "[ERROR] Amount must be a multiple of 1000." }
    }

    // Returns the stored amount
    fun getAmount(): Int {
        return amount
    }

    // Calculates how many lottery tickets can be purchased with the given amount
    fun getTicketCount(): Int {
        return amount / 1000
    }

}
