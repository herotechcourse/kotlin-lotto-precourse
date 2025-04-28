package lotto.view
import camp.nextstep.edu.missionutils.Console

class InputView {
    fun readPurchaseAmount(): Int {
        println("Please enter the purchase amount.")
        val input = Console.readLine()

        try {
            val amount = input.toInt()
            require(amount > 0) { "[ERROR] Purchase amount must be positive." }
            require(amount % 1000 == 0) { "[ERROR] Purchase amount must be a multiple of 1,000 KRW." }
            return amount
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("[ERROR] Please enter a valid number.")
        }
    }

    fun readWinningNumbers(): List<Int> {
        println("\nPlease enter last week's winning numbers.")
        val input = Console.readLine()

        try {
            val numbers = input.split(",").map { it.trim().toInt() }
            require(numbers.size == 6) { "[ERROR] You must provide exactly 6 winning numbers." }
            require(numbers.all { it in 1..45 }) { "[ERROR] Lotto numbers must be between 1 and 45." }
            require(numbers.size == numbers.distinct().size) { "[ERROR] Winning numbers must be unique." }
            return numbers
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("[ERROR] Please enter valid numbers separated by commas.")
        }
    }

    fun readBonusNumber(winningNumbers: List<Int>): Int {
        println("\nPlease enter the bonus number.")
        val input = Console.readLine()

        try {
            val bonusNumber = input.toInt()
            require(bonusNumber in 1..45) { "[ERROR] Bonus number must be between 1 and 45." }
            require(bonusNumber !in winningNumbers) { "[ERROR] Bonus number must not be among the winning numbers." }
            return bonusNumber
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("[ERROR] Please enter a valid number.")
        }
    }
}