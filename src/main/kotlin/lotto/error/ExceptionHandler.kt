package lotto.error

/**
 * Exception thrown when user input needs to be retried.
 * Used to indicate recoverable input errors.
 */
class RetryInputException(message: String) : IllegalArgumentException(message)

/**
 * Exception thrown for unexpected, non-recoverable errors.
 * Used when continuing the program is not possible.
 */
class UnexpectedException(message: String) : IllegalStateException(message)

object ExceptionHandler {
	fun throwIf(errorType: ErrorType) {
		if (errorType == Common.NON_ERROR) return
		if (errorType.isTypeRetry()) throw RetryInputException(errorType.toMessage())
	}
}