package lotto.validator

import lotto.Lotto
import lotto.constants.Constants
import lotto.constants.Messages

object InputValidator {
    fun notEmpty(input: String) {
        if (input.isEmpty()) {
            throw IllegalArgumentException(Messages.Error.INPUT_NOT_EMPTY)
        }
    }

    fun isNumeric(input: String) {
        if (!input.all { it.isDigit() }) {
            throw IllegalArgumentException(Messages.Error.INPUT_MUST_BE_NUMBER)
        }
    }

    fun withinRange(input: Int) {
        if (input < Constants.MIN_PURCHASE_RANGE || input > Constants.MAX_PURCHASE_RANGE) {
            throw IllegalArgumentException(Messages.Error.INPUT_MUST_BE_IN_RANGE)
        }
    }

    fun isMultipleOfThousand(input: Int) {
        if (input % Constants.LOTTO_PURCHASE_UNIT != 0) {
            throw IllegalArgumentException(Messages.Error.INPUT_MUST_BE_MULTIPLE_OF_THOUSAND)
        }
    }

    fun allAreNumbers(input: List<String>) {
        input.forEach {
            isNumeric(it)
        }
    }

    fun checkLottoSize(input: List<Int>) {
        require(input.size == Constants.LOTTO_NUMBERS_COUNT) { Messages.Error.LOTTO_NUMBERS_COUNT }
    }

    fun numberIsRange(input: Int) {
        require(input in Constants.LOTTO_MIN_NUMBER..Constants.LOTTO_MAX_NUMBER) { Messages.Error.LOTTO_NUMBERS_RANGE }
    }

    fun allNumbersInRange(input: List<Int>) {
        input.forEach {
            numberIsRange(it)
        }
    }

    fun noDuplicateNumbers(input: List<Int>) {
        val uniqueNumbers = input.toSet()
        if (uniqueNumbers.size != input.size) {
            throw IllegalArgumentException(Messages.Error.DUPLICATE_NUMBERS)
        }
    }

    fun noDuplicateBonusNumber(bonusNumber: Int, mainLotto: Lotto) {
        require(bonusNumber !in mainLotto.getNumbers()) { Messages.Error.DUPLICATE_BONUS_NUMBER }
    }

}