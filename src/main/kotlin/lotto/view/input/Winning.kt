package lotto.view.input

import lotto.error.Common
import lotto.error.ErrorType
import lotto.error.ParseError
import lotto.error.isStatusFailure
import lotto.policy.hasNoDuplicates
import lotto.policy.hasValidSize
import lotto.policy.isInRange
import lotto.util.validateOrThrow

fun parseWinningNumbers(input: String): List<Int>? {
	val numbers = input.split(',')
		.map(String::trim)
		.map(String::toIntOrNull)

	numbers.validateOrThrow {
		if (it.any { n -> n == null }) ParseError.INVALID_FORMAT else Common.NON_ERROR
	}
	return numbers.map { it!! }
}

fun validateWinningNumbers(numbers: List<Int>): ErrorType {
	return listOf(
		numbers.hasValidSize(),
		numbers.hasNoDuplicates(),
		numbers.isInRange()
	).firstOrNull { it.isStatusFailure() } ?: Common.NON_ERROR
}