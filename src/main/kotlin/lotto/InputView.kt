package lotto

import camp.nextstep.edu.missionutils.Console

object InputView {
    fun readPurchaseAmount(): Int {
        println("Please enter the purchase amount.")
        val input = Console.readLine()
        return input.toIntOrNull()?.also {
            require(it % 1000 == 0) { "Amount must be divisible by 1000." }
        } ?: throw IllegalArgumentException("Invalid purchase amount.")
    }

    fun readWinningNumbers(): List<Int> {
        println("\nPlease enter last week's winning numbers.")
        return Console.readLine()
            .split(",")
            .map { it.trim().toIntOrNull() ?: throw IllegalArgumentException("Winning numbers must be integers.") }
            .also {
                require(it.size == 6) { "Exactly 6 winning numbers required." }
                require(it.distinct().size == 6) { "Winning numbers must be unique." }
                require(it.all { num -> num in 1..45 }) { "Winning numbers must be between 1 and 45." }
            }
    }

    fun readBonusNumber(): Int {
        println("\nPlease enter the bonus number.")
        return Console.readLine()
            .toIntOrNull()?.also {
                require(it in 1..45) { "Bonus number must be between 1 and 45." }
            } ?: throw IllegalArgumentException("Bonus number must be an integer.")
    }
}
