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
            parseNumbers(input)
        } catch (e: IllegalArgumentException) {
            println("[ERROR] Winning numbers must be valid numbers.")
            readWinningNumbers()
        }
    }

//bonus input
fun readBonusNumber(): Int {
    println("Please enter the bonus number.")
    return try {
        val input = Console.readLine()
        input.toIntOrNull() ?: throw IllegalArgumentException()
    } catch (e: IllegalArgumentException) {
        println("[ERROR] Bonus number must be a valid number.")
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
