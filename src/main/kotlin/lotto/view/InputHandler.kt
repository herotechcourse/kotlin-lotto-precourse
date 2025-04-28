package lotto.view

import lotto.config.Messages

class InputHandler {

    fun readPurchaseAmount(readLine: () -> String): Int {
        println(Messages.INPUT_PURCHASE)
        return runCatching {
            val amount = readLine().toInt()
            InputValidator.validateAmount(amount)
            amount
        }.getOrElse { handleError(it) { readPurchaseAmount(readLine) } }
    }

    fun readWinningNumbers(readLine: () -> String): List<Int> {
        println(Messages.INPUT_WINNING_NUMBERS)
        return runCatching {
            val numbers = readLine().split(",").map { it.toInt() }
            InputValidator.validateWinningNumbers(numbers)
            numbers
        }.getOrElse { handleError(it) { readWinningNumbers(readLine) } }
    }

    fun readBonusNumbers(readLine: () -> String, winningNumbers: List<Int>): Int {
        println(Messages.INPUT_BONUS_NUMBER)
        return runCatching {
            val bonusNumber = readLine().toInt()
            InputValidator.validateBonusNumber(bonusNumber, winningNumbers)
            bonusNumber
        }.getOrElse { handleError(it) { readBonusNumbers(readLine, winningNumbers) } }
    }

    private fun <T> handleError(e: Throwable, retry: () -> T): T {
        if (e is NoSuchElementException) throw e
        println(errorMessage(e))
        return retry()
    }

    private fun errorMessage(e: Throwable) = when (e) {
        is NumberFormatException -> Messages.NOT_A_VALID_NUMBER
        is IllegalArgumentException -> e.message ?: Messages.INVALID_INPUT
        else -> Messages.UNEXPECTED_MESSAGE
    }
}