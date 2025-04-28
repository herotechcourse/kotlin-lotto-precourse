package lotto.view

import camp.nextstep.edu.missionutils.Console

object InputView {

    //Only get inputs here
//purchase amount -> int
    fun readPurchaseAmount(): Int {
        println("Please enter the purchase amount.")
        return try {
            val input = Console.readLine()
            input.toIntOrNull() ?: throw IllegalArgumentException()
        } catch (e: IllegalArgumentException) {
            println("[ERROR] Please enter a valid number.")
            readPurchaseAmount()
        }
    }

    //get which number won last week
    fun readWinningNumbers(): List<Int> {
        println("Please enter last week's winning numbers.")
        return try {
            val input = Console.readLine()
            val numbers = parseNumbers(input)
            if (numbers.size != 6) {
                throw IllegalArgumentException("[ERROR] Exactly 6 winning numbers must be provided.")
            }
            if (numbers.any { it !in 1..45 }) {
                throw IllegalArgumentException("[ERROR] Winning numbers must be between 1 and 45.")
            }
            numbers
        } catch (e: IllegalArgumentException) {
            println(e.message)
            readWinningNumbers()
        }
    }



    //bonus input
    fun readBonusNumber(): Int {
        println("Please enter the bonus number.")
        return try {
            val input = Console.readLine()
            val bonus = input.toIntOrNull() ?: throw IllegalArgumentException("[ERROR] Bonus number must be a valid number.")
            if (bonus !in 1..45) {
                throw IllegalArgumentException("[ERROR] Bonus number must be between 1 and 45.")
            }
            bonus
        } catch (e: IllegalArgumentException) {
            println(e.message)
            readBonusNumber()
        }
    }



    private fun parseNumbers(input: String): List<Int> {
        return input.split(",")
            .map { it.trim() }
            .map {
                it.toIntOrNull()
                    ?: throw IllegalArgumentException("[ERROR] Winning numbers must be valid numbers.")
            }
    }

}
