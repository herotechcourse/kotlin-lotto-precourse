package lotto

import camp.nextstep.edu.missionutils.Console

object InputView {
    fun PurchaseAmount(): Int {
        while (true) {
            try {
                println("Please enter the purchase amount.")
                val amount = Console.readLine().trim().toInt()
                require(amount >= 1000 && amount % 1000 == 0) { "[ERROR] Amount must be at least 1,000 and divisible by 1,000." }
                return amount
            } catch (e: NumberFormatException) {
                println("[ERROR] Please enter a valid number.")
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    fun WinningNumbers(): List<Int> {
        while (true) {
            try {
                println("Please enter last week's winning numbers.")
                val input = Console.readLine().trim()
                val numbers = input.split(",").map { it.trim().toInt() }
                require(numbers.size == 6) { "[ERROR] Winning numbers must contain exactly 6 numbers." }
                require(numbers.toSet().size == 6) { "[ERROR] Winning numbers must be unique." }
                require(numbers.all { it in 1..45 }) { "[ERROR] Winning numbers must be between 1 and 45." }
                return numbers
            } catch (e: NumberFormatException) {
                println("[ERROR] Please enter valid numbers separated by commas.")
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    fun BonusNumber(winningNumbers: List<Int>): Int {
        while (true) {
            try {
                println("Please enter the bonus number.")
                val bonus = Console.readLine().trim().toInt()
                require(bonus in 1..45) { "[ERROR] Bonus number must be between 1 and 45." }
                require(bonus !in winningNumbers) { "[ERROR] Bonus number must not be among winning numbers." }
                return bonus
            } catch (e: NumberFormatException) {
                println("[ERROR] Please enter a valid number.")
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }
}