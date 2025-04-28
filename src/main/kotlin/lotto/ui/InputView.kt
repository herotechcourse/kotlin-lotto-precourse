package lotto.ui


import camp.nextstep.edu.missionutils.Console
import lotto.core.BonusNumber
import lotto.core.WinningNumbers
import lotto.core.constant.ErrorMessage.ErrorMessages.LOTTO_BONUS_NUMBER_ERROR
import lotto.core.constant.ErrorMessage.ErrorMessages.LOTTO_WINING_NUMBER__ERROR
import lotto.core.constant.ErrorMessage.ErrorMessages.NOT_A_NUMBER_ERROR
import lotto.core.constant.ErrorMessage.ErrorMessages.NOT_A_POSITIVE_NUMBER_ERROR
import lotto.core.constant.ErrorMessage.ErrorMessages.NOT_DIVISIBLE_BY_1000_ERROR
import lotto.core.constant.LottoConstants.LOTTO_PRICE
import lotto.core.constant.LottoConstants.ZERO


private const val BONUS_MESSAGE = "Please enter the bonus number:"

private const val WIN_NUMBERS_MESSAGE = "Please enter last week's winning numbers (comma-separated):"

private const val PURCHASE_AMOUNT_MESSAGE = "Please enter the purchase amount."

object InputView {
    fun readPurchaseAmount(): Int {
        while (true) {
            try {
                println(PURCHASE_AMOUNT_MESSAGE)
                return parsePurchaseAmount(Console.readLine())
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }


    fun readWinningNumbers(): WinningNumbers {
        while (true) {
            try {
                println(WIN_NUMBERS_MESSAGE)
                val winningNumbersInput = Console.readLine().split(",").map { it.trim() }
                val winningNumbers = winningNumbersInput.map {
                    it.toIntOrNull() ?: throw IllegalArgumentException(
                        LOTTO_WINING_NUMBER__ERROR
                    )
                }
                return WinningNumbers(winningNumbers)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    fun readBonusNumber(): BonusNumber {
        while (true) {
            try {
                println(BONUS_MESSAGE)
                val bonusNumberInput = Console.readLine().toIntOrNull()
                    ?: throw IllegalArgumentException(LOTTO_BONUS_NUMBER_ERROR)
                return BonusNumber(bonusNumberInput)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    private fun parsePurchaseAmount(input: String): Int {
        val amount = input.toIntOrNull()
            ?: throw IllegalArgumentException(NOT_A_NUMBER_ERROR)
        require(amount > ZERO) { NOT_A_POSITIVE_NUMBER_ERROR }
        require(amount % LOTTO_PRICE == ZERO) { NOT_DIVISIBLE_BY_1000_ERROR }
        return amount / LOTTO_PRICE
    }
}
