package lotto.domain.model

import lotto.config.LottoConstants.LOTTO_PRICE
import lotto.config.Messages

class Money(val amount: Int) {
    init {
        require(checkDivisibility(amount)) { Messages.INPUT_NOT_DIVIDABLE }
        require(checkPositive(amount)) { Messages.NUMBER_NOT_POSITIVE }
    }

    val ticketCount: Int = amount / LOTTO_PRICE

    private fun checkDivisibility(purchaseAmount: Int): Boolean = purchaseAmount % LOTTO_PRICE == 0
    private fun checkPositive(purchaseAmount: Int): Boolean = purchaseAmount > 0

}