package lotto

interface IssuedTicketValidator {

    fun validatePurchaseAmount(purchaseAmount: Int) {
        validatePositiveNumber(purchaseAmount)
        validateNonZero(purchaseAmount)
        validateDivisibleByNumber(purchaseAmount, TICKET_COST)
    }

    private fun validatePositiveNumber(number: Int) {
        require(number >= ZERO) {
            "$ERROR_PREFIX Negative numeric '$number' is not allowed."
        }
    }

    private fun validateNonZero(number: Int) {
        require(number != ZERO) {
            "$ERROR_PREFIX Zero is not allowed."
        }
    }

    private fun validateDivisibleByNumber(purchaseAmount: Int, number: Int) {
        require(purchaseAmount % number == ZERO) {
            "$ERROR_PREFIX Purchase amount $purchaseAmount must be divisible by $number."
        }
    }

    companion object {
        private const val ERROR_PREFIX = "[ERROR]"
        private const val ZERO = 0
        private const val TICKET_COST = 1000
    }
}
