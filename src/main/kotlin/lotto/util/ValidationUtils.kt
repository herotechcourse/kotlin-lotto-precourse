package lotto.util

import lotto.error.*

/**
 * Validates the current value and throws a [RetryInputException] if validation fails.
 *
 * @param validation a function that checks the value and returns an [ErrorType]
 * @return the original value if validation passes
 * @throws RetryInputException if validation fails
 */
internal inline fun <T> T.validateOrThrow(validation: (T) -> ErrorType): T {
	val error = validation(this)
	if (error.isStatusFailure()) {
		throw RetryInputException(error.toMessage())
	}
	return this
}

/**
 * Checks the given condition and throws an [UnexpectedException] if it fails.
 *
 * @param condition the boolean condition to check
 * @param lazyMessage a lambda providing the error message if the condition fails
 * @throws UnexpectedException if the condition is false
 */
internal inline fun requireOrUnexpected(condition: Boolean, lazyMessage: () -> String) {
	if (!condition) {
		throw UnexpectedException(lazyMessage())
	}
}