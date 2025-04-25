package lotto


class InputHandler {
    companion object {
        const val INPUT_PURCHASE_MESSAGE = "Please enter the purchase amount."
        const val INPUT_WINNING_NUMBER_MESSAGE = "Please enter last week's winning numbers."
        const val INPUT_BONUS_NUMBER_MESSAGE = "Please enter the bonus number."
        const val LOTTO_PRICE = 1_000
        const val LOTTO_NUMBER_SIZE = 6
        const val LOTTO_NUMBER_STARTS = 1
        const val LOTTO_NUMBER_ENDS = 45
        const val INPUT_NOT_DIVIDABLE = "Input must be divided by lotto amount $LOTTO_PRICE"
        const val NOT_A_VALID_NUMBER = "Please enter a valid number."
        const val WINNING_NUMBER_DUPLICATE = "Please enter non duplicate numbers."
        const val BONUS_NUMBER_DUPLICATE = "Please enter non duplicate number with winning numbers."
        const val WINNING_NUMBER_OVER_RANGE = "Please enter number range in 1 to 45."
        const val WINNING_NUMBER_SIZE_NOT_SIX = "Please enter 6 numbers."
        const val NUMBER_NOT_POSITIVE = "Please enter a positive number."
        const val INVALID_INPUT = "Invalid input."
        const val UNEXPECTED_MESSAGE = "Unexpected error."
    }

    fun readPurchaseAmount(readLine: () -> String): Int {
        while (true) {
            println(INPUT_PURCHASE_MESSAGE)
            return validateAmount { readLine() }
        }
    }

    fun readWinningNumbers(readLine: () -> String): List<Int> {
        while (true) {
            println(INPUT_WINNING_NUMBER_MESSAGE)
            return validateWinningNumbers(readLine)
        }
    }

    fun readBonusNumbers(readLine: () -> String, winningNumbers: List<Int>) : Int{
        while (true) {
            println(INPUT_BONUS_NUMBER_MESSAGE)
            return validateBonusNumbers(readLine, winningNumbers)
        }
    }

    private fun validateWinningNumbers(readLine: () -> String): List<Int> {
        try {
            val winningNumbers = readLine().split(",").map { it.toInt() }
            validateWinningNumbers(winningNumbers)
            return winningNumbers
        } catch (e: Exception) {
            println(errorMessage(e))
            throw e
        }
    }

    private fun validateBonusNumbers(readLine: () -> String, winningNumbers: List<Int>): Int {
        try {
            val bonusNumber = readLine().toInt()
            validateBonusNumber(bonusNumber, winningNumbers)
            return bonusNumber
        } catch (e: Exception) {
            println(errorMessage(e))
            throw e
        }
    }

    private fun validateAmount(readLine: () -> String): Int {
        try {
            val amount = readLine().toInt()
            validatePurchaseAmount(amount)
            return amount
        } catch (e: Exception) {
            println(errorMessage(e))
            throw e
        }
    }

    private fun validatePurchaseAmount(purchaseAmount: Int) {
        checkDivisibility(purchaseAmount)
        checkPositive(purchaseAmount)
    }

    private fun validateWinningNumbers(winningNumbers: List<Int>) {
        checkDuplicates(winningNumbers)
        checkRange(winningNumbers)
        checkSize(winningNumbers)
    }

    private fun validateBonusNumber(bonusNumber: Int, winningNumbers: List<Int>) {
        checkRange(bonusNumber)
        checkDuplicates(bonusNumber, winningNumbers)
    }

    private fun checkDuplicates(numbers: List<Int>) {
        if (numbers.toSet().size != numbers.size) {
            throw IllegalArgumentException(WINNING_NUMBER_DUPLICATE)
        }
    }

    private fun checkDuplicates(bonusNumber: Int, winningNumbers: List<Int>) {
        if (winningNumbers.contains(bonusNumber)) {
            throw IllegalArgumentException(BONUS_NUMBER_DUPLICATE)
        }
    }

    private fun checkRange(numbers: List<Int>) {
        for (number in numbers) {
            if (number < LOTTO_NUMBER_STARTS || number > LOTTO_NUMBER_ENDS) {
                throw IllegalArgumentException(WINNING_NUMBER_OVER_RANGE)
            }
        }
    }

    private fun checkRange(number: Int) {
        if (number < LOTTO_NUMBER_STARTS || number > LOTTO_NUMBER_ENDS) {
            throw IllegalArgumentException(WINNING_NUMBER_OVER_RANGE)
        }
    }

    private fun checkSize(numbers: List<Int>) {
        if (numbers.size != LOTTO_NUMBER_SIZE) {
            throw IllegalArgumentException(WINNING_NUMBER_SIZE_NOT_SIX)
        }
    }

    private fun checkDivisibility(purchaseAmount: Int) {
        if (purchaseAmount % LOTTO_PRICE != 0) {
            throw IllegalArgumentException(INPUT_NOT_DIVIDABLE)
        }
    }

    private fun checkPositive(purchaseAmount: Int) {
        if (purchaseAmount <= 0) {
            throw IllegalArgumentException(NUMBER_NOT_POSITIVE)
        }
    }

    private fun errorMessage(e: Throwable): String {
        when (e) {
            is NumberFormatException -> return NOT_A_VALID_NUMBER
            is IllegalArgumentException -> return e.message ?: INVALID_INPUT
            else -> return UNEXPECTED_MESSAGE
        }
    }
}