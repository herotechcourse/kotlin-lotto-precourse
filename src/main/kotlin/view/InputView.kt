package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.domain.LottoPurchase
import lotto.domain.WinningNumbers

object InputView {
    private const val LOTTO_PRICE = 1000
    private const val MIN_NUMBER = 1
    private const val MAX_NUMBER = 45
    private const val NUMBERS_COUNT = 6

    fun getPurchaseAmount(): Int {
        println("Please enter the purchase amount.")
        val input = Console.readLine()
        val amount = input.toIntOrNull() ?: throw IllegalArgumentException("[ERROR] Please enter a valid number.")
        require(amount % LOTTO_PRICE == 0) { "[ERROR] Amount must be divisible by $LOTTO_PRICE." }
        return amount
    }

    fun getWinningNumbers(): List<Int> {
        println("\nPlease enter last week's winning numbers.")
        val input = Console.readLine()
        val numbers = input.split(",")
            .map { it.trim().toIntOrNull() ?: throw IllegalArgumentException("[ERROR] Please enter valid numbers.") }
        validateWinningNumbers(numbers)
        return numbers.sorted()
    }

    fun getBonusNumber(winningNumbers: List<Int>): Int {
        println("\nPlease enter the bonus number.")
        val input = Console.readLine()
        val bonusNumber = input.toIntOrNull() ?: throw IllegalArgumentException("[ERROR] Please enter a valid number.")
        validateBonusNumber(bonusNumber, winningNumbers)
        return bonusNumber
    }

    private fun validateWinningNumbers(numbers: List<Int>) {
        require(numbers.size == NUMBERS_COUNT) { "[ERROR] Please enter exactly $NUMBERS_COUNT numbers." }
        require(numbers.all { it in MIN_NUMBER..MAX_NUMBER }) { 
            "[ERROR] Lotto numbers must be between $MIN_NUMBER and $MAX_NUMBER." 
        }
        require(numbers.distinct().size == NUMBERS_COUNT) { "[ERROR] Numbers must be unique." }
    }

    private fun validateBonusNumber(bonusNumber: Int, winningNumbers: List<Int>) {
        require(bonusNumber in MIN_NUMBER..MAX_NUMBER) { 
            "[ERROR] Bonus number must be between $MIN_NUMBER and $MAX_NUMBER." 
        }
        require(bonusNumber !in winningNumbers) { "[ERROR] Bonus number must not be in winning numbers." }
    }
}
