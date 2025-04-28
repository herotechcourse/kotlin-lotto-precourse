package lotto.validation

import lotto.constant.LottoConstants

object LottoValidator {
    fun validatePurchaseAmount(input: String): Int {
        val amount = input.toIntOrNull() ?: throw IllegalArgumentException("[ERROR] Purchase amount must be a number.")
        validateAmountIsPositive(amount)
        validateAmountIsMultipleOfPrice(amount)
        return amount
    }

    private fun validateAmountIsPositive(amount: Int) {
        if (amount <= 0) {
            throw IllegalArgumentException("[ERROR] Purchase amount must be greater than 0.")
        }
    }

    fun validateAmountIsMultipleOfPrice(amount: Int) {
        if (amount % LottoConstants.LOTTO_PRICE != 0) {
            throw IllegalArgumentException("[ERROR] Purchase amount must be a multiple of ${LottoConstants.LOTTO_PRICE}.")
        }
    }

    fun validateWinningNumbersInput(input: String): List<Int> {
        val numbers = parseNumbers(input)
        validateLottoNumbers(numbers)
        return numbers
    }

    /** Parses a comma-separated string into a list of integers. */
    private fun parseNumbers(input: String): List<Int> {
        return input.split(",")
            .map { it.trim() }
            .map { parseSingleNumber(it) }
    }

    /** Parses a single string into an integer. */
    private fun parseSingleNumber(numberStr: String): Int {
        return numberStr.toIntOrNull() ?: throw IllegalArgumentException("[ERROR] Lotto numbers must be numeric.")
    }

    fun validateLottoNumbers(numbers: List<Int>) {
        validateSize(numbers)
        validateDuplicates(numbers)
        validateRange(numbers)
    }

    private fun validateSize(numbers: List<Int>) {
        if (numbers.size != LottoConstants.LOTTO_NUMBER_COUNT) {
            throw IllegalArgumentException("[ERROR] Lotto numbers must contain exactly ${LottoConstants.LOTTO_NUMBER_COUNT} numbers.")
        }
    }

    private fun validateDuplicates(numbers: List<Int>) {
        // Use constant from LottoConstants
        if (numbers.toSet().size != LottoConstants.LOTTO_NUMBER_COUNT) {
            throw IllegalArgumentException("[ERROR] Lotto numbers cannot contain duplicates.")
        }
    }

    /** Validates that all numbers in the list are within the allowed range. */
    private fun validateRange(numbers: List<Int>) {
        numbers.forEach { validateNumberRange(it) }
    }

    /** Validates a single lotto number's range. */
    fun validateNumberRange(number: Int) {
        if (number !in LottoConstants.MIN_LOTTO_NUMBER..LottoConstants.MAX_LOTTO_NUMBER) {
            throw IllegalArgumentException("[ERROR] Lotto numbers must be between ${LottoConstants.MIN_LOTTO_NUMBER} and ${LottoConstants.MAX_LOTTO_NUMBER}.")
        }
    }

    fun validateBonusNumber(bonusNumberInput: String, winningNumbers: List<Int>): Int {
        val bonusNumber = parseSingleNumber(bonusNumberInput)
        validateNumberRange(bonusNumber)
        validateBonusNumberDuplication(bonusNumber, winningNumbers)
        return bonusNumber
    }

    fun validateBonusNumberDuplication(bonusNumber: Int, winningNumbers: List<Int>) {
        if (winningNumbers.contains(bonusNumber)) {
            throw IllegalArgumentException("[ERROR] Bonus number cannot be the same as a winning number.")
        }
    }
}