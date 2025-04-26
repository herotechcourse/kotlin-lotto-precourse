package lotto.validator

import lotto.constants.Constants

object ValidationBundle {

    fun purchaseAmount(input: String) {
        InputValidator.notEmpty(input)
        InputValidator.onlyContainsDigits(input)

        val purchaseAmount = input.toInt()
        InputValidator.withinPurchaseRange(purchaseAmount)
        InputValidator.isMultipleOfThousand(purchaseAmount)
    }

    fun winningNumbers(input: String) {
        InputValidator.notEmpty(input)
        val numbers = input.split(Constants.SEPARATOR).map { it.trim() }
        InputValidator.allAreDigits(numbers)
    }

    fun bonusNumber(input: String) {
        InputValidator.notEmpty(input)
        InputValidator.onlyContainsDigits(input)
    }
}