package lotto.view

import camp.nextstep.edu.missionutils.Console

object InputView {

    //Only get inputs here
//purchase amount -> int
    fun readPurchaseAmount(): Int {
        println("Please enter the purchase amount.")
        val input = Console.readLine()
        return input.toIntOrNull()
            ?: throw IllegalArgumentException("[ERROR] Please enter a valid number.")
    }
//get which number won last week
fun readWinningNumbers(): List<Int> {
    println("Please enter last week's winning numbers.")
    val input = Console.readLine()
    return parseNumbers(input)
}
//bonus input
    fun readBonusNumber(): Int {
        println("Please enter the bonus number.")
        val input = Console.readLine()
        return input.toIntOrNull()
            ?: throw IllegalArgumentException("[ERROR] Bonus number must be a valid number.")
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
