package lotto

import camp.nextstep.edu.missionutils.Console

const val TICKET_PRICE: Int = 1000
const val WINNING_NUMBER_RANGE_MIN = 1
const val WINNING_NUMBER_RANGE_MAX = 45

object InputView {

    fun getPurchaseAmount(): Int = retryUntilInputIsValid { getAndParsePurchaseAmount() }
    fun getWinningAndBonusNumbers(): List<Int> {
        val winningNumbers: MutableList<Int> = getWinningNumbers().toMutableList()
        val bonusNumber: Int = getBonusNumber(winningNumbers)
        winningNumbers.add(bonusNumber)
        return winningNumbers
    }

    private fun getWinningNumbers(): List<Int> = retryUntilInputIsValid { getAndParseWinningNumbers() }
    private fun getBonusNumber(winningNumbers: List<Int>): Int =
        retryUntilInputIsValid { getAndParseBonusNumber(winningNumbers) }

    private inline fun <T> retryUntilInputIsValid(getValue: () -> T): T {
        while (true) {
            try {
                return getValue()
            } catch (e: IllegalArgumentException) {
                OutputView.ERROR.printMessage(e.message ?: "Invalid input.")
            }
        }
    }

    private fun getAndParsePurchaseAmount(): Int {
        OutputView.REQUEST_PURCHASE_AMOUNT.printMessage(null)
        val amount = Console.readLine().toInt()
        if (amount % TICKET_PRICE != 0) throw IllegalArgumentException("Amount has to be divisible by 1000.")
        return amount
    }

    private fun getAndParseWinningNumbers(): List<Int> {
        OutputView.REQUEST_WINNING_NUMBERS.printMessage(null)
        val numbers: List<Int> = Console.readLine().split(',').map { it.toInt() }
        return numbers
    }

    private fun getAndParseBonusNumber(winningNumbers: List<Int>): Int {
        OutputView.REQUEST_BONUS_NUMBER.printMessage(null)
        val bonusNumber = Console.readLine().toInt()
        if (bonusNumber !in WINNING_NUMBER_RANGE_MIN..WINNING_NUMBER_RANGE_MAX)
            throw IllegalArgumentException("Lotto numbers must be between 1 and 45.")
        if (bonusNumber in winningNumbers)
            throw IllegalArgumentException("This bonus number is already in wining numbers.")
        return bonusNumber
    }
}