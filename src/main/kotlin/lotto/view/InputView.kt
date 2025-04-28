package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.Lotto

object InputView {
    fun readPurchaseAmount(): Int {
        println("Please enter the purchase amount.")
        val input = Console.readLine()
        val purchaseAmount = input.toIntOrNull() ?: throw IllegalArgumentException("[ERROR] Please enter a valid number.")

        if (purchaseAmount % 1000 != 0) {
            throw IllegalArgumentException("[ERROR] The purchase amount must be divisible by 1000.")
        }
        return purchaseAmount
    }

    fun readWinningNumbers(): Lotto {
        println("\nPlease enter last week's winning numbers.")
        val input = Console.readLine()
        val numbers = input.split(",")
            .map { it.trim().toIntOrNull() ?: throw IllegalArgumentException("[ERROR] Winning numbers must be numbers.") }

        if (numbers.size != numbers.distinct().size) {
            throw IllegalArgumentException("[ERROR] Winning numbers must not contain duplicates.")
        }

        if (numbers.size != 6) {
            throw IllegalArgumentException("[ERROR] Must enter exactly 6 winning numbers.")
        }

        return Lotto(numbers.sorted())
    }

    fun readBonusNumber(): Int {
        println("\nPlease enter the bonus number.")
        val input = Console.readLine()
        val bonus = input.toIntOrNull() ?: throw IllegalArgumentException("[ERROR] Bonus number must be a number.")
        if (bonus !in 1..45) {
            throw IllegalArgumentException("[ERROR] Bonus number must be between 1 and 45.")
        }
        return bonus
    }

}

