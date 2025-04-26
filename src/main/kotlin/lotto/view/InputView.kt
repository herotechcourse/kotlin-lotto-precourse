package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.domain.Lotto

object InputView {
    fun getPurchaseAmount(): Int {
        println("Please enter the purchase amount.")
        return readLineWithValidation("Purchase amount must be at least 1000 and divisible by 1000.") {
            it.toInt().also { amount ->
                require(amount >= 1000) { "Purchase amount must be at least 1000." }
                require(amount % 1000 == 0) { "Purchase amount must be divisible by 1000." }
            }
        }
    }

    fun getWinningNumbers(): Lotto {
        println("\nPlease enter last week's winning numbers (comma-separated).")
        return readLineWithValidation("Please enter 6 unique numbers between 1 and 45.") { input ->
            input.split(",")
                .map { it.trim().toInt() }
                .let { Lotto(it) }
        }
    }

    fun getBonusNumber(winningNumbers: Lotto): Int {
        println("\nPlease enter the bonus number.")
        return readLineWithValidation("Bonus number must be between 1 and 45 and not in winning numbers.") { input ->
            val bonus = input.trim().toInt()
            require(bonus in 1..45) { "Bonus number must be between 1 and 45." }
            require(!winningNumbers.contains(bonus)) { "Bonus number must not be in winning numbers." }
            bonus
        }
    }

    private inline fun <T> readLineWithValidation(errorMessage: String, validator: (String) -> T): T {
        while (true) {
            try {
                return validator(Console.readLine())
            } catch (e: IllegalArgumentException) {
                println("[ERROR] ${e.message ?: errorMessage}")
            } catch (e: NumberFormatException) {
                println("[ERROR] Please enter valid numbers.")
            }
        }
    }
}