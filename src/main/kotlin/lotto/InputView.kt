package lotto

import camp.nextstep.edu.missionutils.Console

/**
 * InputView is responsible for collecting user input and validating it.
 * All console output operations are delegated to OutputView.
 */
class InputView(private val outputView: OutputView) {
    companion object {
        private const val PURCHASE_AMOUNT_PROMPT = "Please enter the purchase amount."
        private const val WINNING_NUMBERS_PROMPT = "Please enter last week's winning numbers."
        private const val BONUS_NUMBER_PROMPT = "Please enter the bonus number."
        private const val INVALID_NUMBER_ERROR = "[ERROR] Please enter a valid number."
        private const val AMOUNT_GREATER_THAN_ZERO_ERROR = "[ERROR] Purchase amount must be greater than 0."
        private const val AMOUNT_MULTIPLE_ERROR = "[ERROR] Purchase amount must be a multiple of 1,000."
        private const val EXACTLY_SIX_NUMBERS_ERROR = "[ERROR] Please enter exactly 6 winning numbers."
        private const val NUMBER_RANGE_ERROR = "[ERROR] Lotto numbers must be between 1 and 45."
        private const val NO_DUPLICATES_ERROR = "[ERROR] Lotto numbers must not contain duplicates."
        private const val BONUS_NOT_WINNING_ERROR = "[ERROR] Bonus number must not be one of the winning numbers."
    }

    fun readPurchaseAmount(): Int {
        outputView.printPrompt(PURCHASE_AMOUNT_PROMPT)
        val input = readInput()
        return parseAndValidatePurchaseAmount(input)
    }

    fun readWinningNumbers(): List<Int> {
        outputView.printPrompt(WINNING_NUMBERS_PROMPT)
        val input = readInput()
        val numbers = parseCommaDelimitedNumbers(input)
        validateWinningNumbers(numbers)
        return numbers
    }

    fun readBonusNumber(winningNumbers: List<Int>): Int {
        outputView.printPrompt(BONUS_NUMBER_PROMPT)
        val input = readInput()
        return parseAndValidateBonusNumber(input, winningNumbers)
    }

    private fun readInput(): String {
        return Console.readLine()
    }

    private fun parseAndValidatePurchaseAmount(input: String): Int {
        try {
            val amount = input.toInt()
            validatePurchaseAmount(amount)
            return amount
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException(INVALID_NUMBER_ERROR)
        }
    }

    private fun validatePurchaseAmount(amount: Int) {
        validateAmountIsPositive(amount)
        validateAmountIsMultipleOfThousand(amount)
    }

    private fun validateAmountIsPositive(amount: Int) {
        if (amount <= 0) {
            throw IllegalArgumentException(AMOUNT_GREATER_THAN_ZERO_ERROR)
        }
    }

    private fun validateAmountIsMultipleOfThousand(amount: Int) {
        if (amount % 1000 != 0) {
            throw IllegalArgumentException(AMOUNT_MULTIPLE_ERROR)
        }
    }

    private fun parseCommaDelimitedNumbers(input: String): List<Int> {
        return try {
            input.split(",").map { it.trim().toInt() }
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException(INVALID_NUMBER_ERROR)
        }
    }

    private fun validateWinningNumbers(numbers: List<Int>) {
        validateNumberCount(numbers)
        validateNumberRange(numbers)
        validateNoDuplicates(numbers)
    }

    private fun validateNumberCount(numbers: List<Int>) {
        if (numbers.size != 6) {
            throw IllegalArgumentException(EXACTLY_SIX_NUMBERS_ERROR)
        }
    }

    private fun validateNumberRange(numbers: List<Int>) {
        if (numbers.any { it !in 1..45 }) {
            throw IllegalArgumentException(NUMBER_RANGE_ERROR)
        }
    }

    private fun validateNoDuplicates(numbers: List<Int>) {
        if (numbers.toSet().size != numbers.size) {
            throw IllegalArgumentException(NO_DUPLICATES_ERROR)
        }
    }

    private fun parseAndValidateBonusNumber(input: String, winningNumbers: List<Int>): Int {
        try {
            val bonusNumber = input.toInt()
            validateBonusNumber(bonusNumber, winningNumbers)
            return bonusNumber
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException(INVALID_NUMBER_ERROR)
        }
    }

    private fun validateBonusNumber(bonusNumber: Int, winningNumbers: List<Int>) {
        validateNumberRange(listOf(bonusNumber))
        validateBonusIsNotWinningNumber(bonusNumber, winningNumbers)
    }

    private fun validateBonusIsNotWinningNumber(bonusNumber: Int, winningNumbers: List<Int>) {
        if (bonusNumber in winningNumbers) {
            throw IllegalArgumentException(BONUS_NOT_WINNING_ERROR)
        }
    }
} 