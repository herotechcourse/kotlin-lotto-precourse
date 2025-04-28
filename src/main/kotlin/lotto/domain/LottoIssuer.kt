package lotto.domain

import lotto.Lotto
import lotto.error.PurchaseError
import lotto.error.isStatusSuccess
import lotto.error.toMessage
import lotto.policy.GamePolicy
import lotto.policy.isAtLeastTicketPrice
import lotto.policy.isBelowMaxAllowableAmount
import lotto.policy.isDivisibleByTicketPrice


class LottoIssuer(private val amount: Long) {
	init {
		validateIssuer()
	}

	val ticketCount: Int
		get() = (amount / GamePolicy.TICKET_PRICE).toInt()

	fun issue(): List<Lotto> {
		return List(ticketCount) {
			Lotto(LottoNumbers.generate())
		}
	}

	private fun validateIssuer() {
		require(amount.isAtLeastTicketPrice().isStatusSuccess()) {
			PurchaseError.CANNOT_AFFORD_TICKET.toMessage()
		}
		require(
			amount.isDivisibleByTicketPrice().isStatusSuccess()
		) { PurchaseError.NOT_DIVISIBLE_BY_TICKET_PRICE.toMessage() }
		require(amount.isBelowMaxAllowableAmount().isStatusSuccess()) {
			PurchaseError.AMOUNT_TOO_LARGE.toMessage()
		}
	}
}