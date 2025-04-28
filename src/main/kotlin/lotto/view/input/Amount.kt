package lotto.view.input

import lotto.error.Common
import lotto.error.ErrorType
import lotto.error.isStatusFailure
import lotto.policy.isAtLeastTicketPrice
import lotto.policy.isBelowMaxAllowableAmount
import lotto.policy.isDivisibleByTicketPrice

fun parseAmountOrNull(input: String): Long? {
	return input.toLongOrNull()
}

fun validateAmount(amount: Long): ErrorType {
	return listOf(
		amount.isAtLeastTicketPrice(),
		amount.isDivisibleByTicketPrice(),
		amount.isBelowMaxAllowableAmount()
	).firstOrNull { it.isStatusFailure() } ?: Common.NON_ERROR
}