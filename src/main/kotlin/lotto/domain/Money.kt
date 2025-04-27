package lotto.domain

import lotto.InputHandler.Companion.INPUT_NOT_DIVIDABLE
import lotto.InputHandler.Companion.LOTTO_PRICE
import lotto.InputHandler.Companion.NUMBER_NOT_POSITIVE

class Money(val amount: Int) {
    init {
        require(checkDivisibility(amount)) {
            INPUT_NOT_DIVIDABLE
        }
        require(checkPositive(amount)) {
            NUMBER_NOT_POSITIVE
        }
    }

    val ticketCount: Int = amount / LOTTO_PRICE

    private fun checkDivisibility(purchaseAmount: Int): Boolean = purchaseAmount % LOTTO_PRICE == 0
    private fun checkPositive(purchaseAmount: Int): Boolean = purchaseAmount > 0

}