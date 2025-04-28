package lotto

import camp.nextstep.edu.missionutils.Console

class InputView {
    fun getPurchaseAmount(): Int {
        println("Please enter the purchase amount.")
        val input = Console.readLine()
        return try {
            val amount = input.toInt()
            require(amount % 1000 == 0) { "[ERROR] Purchase amount must be divisible by 1,000." }
            amount
        } catch (e: Exception) {
            println("[ERROR] Invalid input. Please try again.")
            getPurchaseAmount()
        }
    }

    fun getWinningNumbers(): List<Int> {
        println("Please enter last week's winning numbers.")
        val input = Console.readLine()
        return input.split(",").map {
            try {
                it.trim().toInt()
            } catch (e: Exception) {
                throw IllegalArgumentException("[ERROR] Invalid number format.")
            }
        }.let {
            require(it.size == 6) { "[ERROR] Winning numbers must contain exactly 6 numbers." }
            require(it.all { num -> num in 1..45 }) { "[ERROR] Winning numbers must be between 1 and 45." }
            it
        }
    }

    fun getBonusNumber(): Int {
        println("Please enter the bonus number.")
        val input = Console.readLine()
        return try {
            val bonus = input.toInt()
            require(bonus in 1..45) { "[ERROR] Bonus number must be between 1 and 45." }
            bonus
        } catch (e: Exception) {
            println("[ERROR] Invalid bonus number. Please try again.")
            getBonusNumber()
        }
    }
}
