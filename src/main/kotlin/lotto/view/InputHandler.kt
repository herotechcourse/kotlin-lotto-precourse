package lotto.view

import lotto.config.LottoConstants.LOTTO_NUMBER_ENDS
import lotto.config.LottoConstants.LOTTO_NUMBER_SIZE
import lotto.config.LottoConstants.LOTTO_NUMBER_STARTS
import lotto.config.LottoConstants.LOTTO_PRICE
import lotto.config.Messages

class InputHandler {

    fun readPurchaseAmount(readLine: () -> String): Int {
        return try {
            println(Messages.INPUT_PURCHASE)
            validateAmount(readLine)
        } catch (e: Exception) {
            if (e is NoSuchElementException) throw e
            println(errorMessage(e))
            readPurchaseAmount(readLine)
        }
    }

    fun readWinningNumbers(readLine: () -> String): List<Int> {
        return try {
            println(Messages.INPUT_WINNING_NUMBERS)
            validateWinningNumbers(readLine)
        } catch (e: Exception) {
            if (e is NoSuchElementException) throw e
            println(errorMessage(e))
            readWinningNumbers(readLine)
        }
    }

    fun readBonusNumbers(readLine: () -> String, winningNumbers: List<Int>): Int {
        return try {
            println(Messages.INPUT_BONUS_NUMBER)
            validateBonusNumbers(readLine, winningNumbers)
        } catch (e: Exception) {
            if (e is NoSuchElementException) throw e
            println(errorMessage(e))
            readBonusNumbers(readLine, winningNumbers)
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
            throw IllegalArgumentException(Messages.WINNING_NUMBER_DUPLICATE)
        }
    }

    private fun checkDuplicates(bonusNumber: Int, winningNumbers: List<Int>) {
        if (winningNumbers.contains(bonusNumber)) {
            throw IllegalArgumentException(Messages.BONUS_NUMBER_DUPLICATE)
        }
    }

    private fun checkRange(numbers: List<Int>) {
        for (number in numbers) {
            if (number < LOTTO_NUMBER_STARTS || number > LOTTO_NUMBER_ENDS) {
                throw IllegalArgumentException(Messages.WINNING_NUMBER_OVER_RANGE)
            }
        }
    }

    private fun checkRange(number: Int) {
        if (number < LOTTO_NUMBER_STARTS || number > LOTTO_NUMBER_ENDS) {
            throw IllegalArgumentException(Messages.WINNING_NUMBER_OVER_RANGE)
        }
    }

    private fun checkSize(numbers: List<Int>) {
        if (numbers.size != LOTTO_NUMBER_SIZE) {
            throw IllegalArgumentException(Messages.WINNING_NUMBER_SIZE_NOT_SIX)
        }
    }

    private fun checkDivisibility(purchaseAmount: Int) {
        if (purchaseAmount % LOTTO_PRICE != 0) {
            throw IllegalArgumentException(Messages.INPUT_NOT_DIVIDABLE)
        }
    }

    private fun checkPositive(purchaseAmount: Int) {
        if (purchaseAmount <= 0) {
            throw IllegalArgumentException(Messages.NUMBER_NOT_POSITIVE)
        }
    }

    private fun errorMessage(e: Throwable): String {
        return when (e) {
            is NumberFormatException -> Messages.NOT_A_VALID_NUMBER
            is IllegalArgumentException -> e.message ?: Messages.INVALID_INPUT
            else -> Messages.UNEXPECTED_MESSAGE
        }
    }
}