package lotto

import camp.nextstep.edu.missionutils.Console

object InputView {

    fun readPurchaseAmount() : Int {
        println("Please enter the purchase amount.")
        val input = Console.readLine()
        return input.toIntOrNull()?.takeIf { it >= 1000 && it % 1000 ==0 }
            ?: throw IllegalArgumentException("[ERROR] Amount must be a positive number divisible by 1000.")
    }

    fun readWinningNumber() : List<Int> {
        println("Please enter last week's winning numbers.")
        val input = Console.readLine()
        val numbers = input.split(",").mapNotNull { it.trim().toIntOrNull() }
        if (numbers.size != 6 || numbers.distinct().size != 6 || numbers.any { it !in 1..45 }) {
            throw IllegalArgumentException("[ERROR] Winning numbers must be 6 unique numbers between 1 and 45.")
        }
        return numbers
    }
    fun readBonusNumber(): Int {
        println("Please enter the bonus number.")
        return Console.readLine().toIntOrNull()?.takeIf { it in 1..45 }
            ?: throw IllegalArgumentException("[ERROR] Bonus number must be between 1 and 45.")
    }
}
