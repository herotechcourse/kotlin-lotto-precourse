package lotto

import lotto.Consts.TICKET_COST
import lotto.Consts.ZERO

interface IssuedTicketValidator {

    fun validatePurchaseAmount(purchaseAmount: Int) {
        validatePositiveNumber(purchaseAmount)
        validateNonZero(purchaseAmount)
        validateDivisibleByNumber(purchaseAmount, TICKET_COST)
    }

    private fun validatePositiveNumber(number: Int) {
        require(number >= ZERO) {
            "Negative numeric '$number' is not allowed."
        }
    }

    private fun validateNonZero(number: Int) {
        require(number != ZERO) {
            "Zero is not allowed."
        }
    }

    private fun validateDivisibleByNumber(purchaseAmount: Int, number: Int) {
        require(purchaseAmount % number == ZERO) {
            "Purchase amount $purchaseAmount must be divisible by $number."
        }
    }
}
