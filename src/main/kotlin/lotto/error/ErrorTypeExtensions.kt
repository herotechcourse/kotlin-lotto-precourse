package lotto.error

import lotto.policy.GamePolicy

fun ErrorType.toMessage(): String {
	return when (this) {
		is WinningError -> fromWinning(this)
		is BonusError -> fromBonus(this)
		is PurchaseError -> fromPurchase(this)
		is ParseError -> fromParse(this)
		is LottoError -> "${GamePolicy.ERROR_PREFIX} Lotto numbers must be sorted."
		Common.NON_ERROR -> "[OK]: Operation completed successfully."
	}
}

fun ErrorType.isTypeRetry(): Boolean =
	this is ParseError || this is WinningError || this is BonusError || this is PurchaseError

fun ErrorType.isStatusFailure(): Boolean = this != Common.NON_ERROR

fun ErrorType.isStatusSuccess(): Boolean = this == Common.NON_ERROR

private fun fromWinning(type: WinningError): String = when (type) {
	WinningError.INVALID_SIZE -> ErrorTemplate.numberCount(GamePolicy.LOTTO_SIZE)
	WinningError.NOT_IN_RANGE -> ErrorTemplate.numberRange(
		"lotto numbers",
		GamePolicy.LOTTO_MIN_NUMBER,
		GamePolicy.LOTTO_MAX_NUMBER
	)

	WinningError.DUPLICATE_NUMBER -> ErrorTemplate.duplicate("numbers")
}

private fun fromBonus(type: BonusError): String = when (type) {
	BonusError.NOT_IN_RANGE -> ErrorTemplate.numberRange(
		"bonus number",
		GamePolicy.LOTTO_MIN_NUMBER,
		GamePolicy.LOTTO_MAX_NUMBER
	)

	BonusError.DUPLICATE_NUMBER -> ErrorTemplate.duplicate("bonus number")
}

private fun fromPurchase(type: PurchaseError): String = when (type) {
	PurchaseError.CANNOT_AFFORD_TICKET -> ErrorTemplate.invalidPurchaseAmount(GamePolicy.TICKET_PRICE)
	PurchaseError.NOT_DIVISIBLE_BY_TICKET_PRICE -> ErrorTemplate.notDivisibleBy(
		"purchase amount",
		GamePolicy.TICKET_PRICE
	)

	PurchaseError.AMOUNT_TOO_LARGE -> "Purchase amount is too large to process."
}

private fun fromParse(type: ParseError): String = when (type) {
	ParseError.NULL_FOUND -> ErrorTemplate.inputEmpty()
	ParseError.INVALID_FORMAT -> ErrorTemplate.invalidInputFormat()
}