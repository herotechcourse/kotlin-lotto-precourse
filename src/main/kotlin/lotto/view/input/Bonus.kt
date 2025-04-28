package lotto.view.input

import lotto.error.ErrorType
import lotto.policy.isInRange

fun parseBonusNumber(input: String): Int? {
	return input.toIntOrNull()
}

fun validateBonusNumber(number: Int): ErrorType {
	return number.isInRange()
}
