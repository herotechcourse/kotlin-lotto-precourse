package lotto.error

sealed interface ErrorType

enum class Common : ErrorType {
	NON_ERROR
}

enum class ParseError : ErrorType {
	NULL_FOUND,
	INVALID_FORMAT
}

enum class WinningError : ErrorType {
	INVALID_SIZE,
	NOT_IN_RANGE,
	DUPLICATE_NUMBER
}

enum class BonusError : ErrorType {
	NOT_IN_RANGE,
	DUPLICATE_NUMBER
}

enum class PurchaseError : ErrorType {
	CANNOT_AFFORD_TICKET,
	NOT_DIVISIBLE_BY_TICKET_PRICE,
	AMOUNT_TOO_LARGE
}

enum class LottoError : ErrorType {
	NOT_SORTED
}