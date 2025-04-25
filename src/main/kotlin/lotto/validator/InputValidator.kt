package lotto.validator

import lotto.Lotto
import lotto.constants.Constants

object InputValidator {
    fun notEmpty(input: String) {
        if (input.isEmpty()) {
            throw IllegalArgumentException("[ERROR] Input cannot be empty.")
        }
    }

    fun isNumeric(input: String) {
        if (!input.all { it.isDigit() }) {
            throw IllegalArgumentException("[ERROR] Input must be a number.")
        }
    }

    fun withinRange(input: Int) {
        if (input < Constants.MIN_PURCHASE_RANGE || input > Constants.MAX_PURCHASE_RANGE) {
            throw IllegalArgumentException("[ERROR] Input must be a number between ${Constants.MIN_PURCHASE_RANGE} and ${Constants.MAX_PURCHASE_RANGE}.")
        }
    }

    fun isMultipleOfThousand(input: Int) {
        if (input % Constants.LOTTO_PURCHASE_UNIT != 0) {
            throw IllegalArgumentException("[ERROR] Input must be a multiple of ${Constants.LOTTO_PURCHASE_UNIT}.")
        }
    }

    fun allAreNumbers(input: List<String>) {
        input.forEach {
            isNumeric(it)
        }
    }

    fun checkLottoSize(input: List<Int>) {
        require(input.size == Constants.LOTTO_NUMBERS_COUNT) { "[ERROR] Lotto must contain exactly 6 numbers." }
    }

    fun numberIsRange(input: Int) {
        require(input in Constants.LOTTO_MIN_NUMBER..Constants.LOTTO_MAX_NUMBER) { "[ERROR] Numbers must be between 1 and 45." }
    }

    fun allNumbersInRange(input: List<Int>) {
        input.forEach {
            numberIsRange(it)
        }
    }

    fun noDuplicateNumbers(input: List<Int>) {
        val uniqueNumbers = input.toSet()
        if (uniqueNumbers.size != input.size) {
            throw IllegalArgumentException("[ERROR] Duplicate numbers are not allowed.")
        }
    }

    fun noDuplicateBonusNumber(bonusNumber: Int, mainLotto: Lotto) {
        require(bonusNumber !in mainLotto.getNumbers()) { "[ERROR] Bonus number must not be in the main lotto numbers." }
    }

}