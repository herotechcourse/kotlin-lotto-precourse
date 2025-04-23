package lotto

import camp.nextstep.edu.missionutils.Console

object InputView {
    fun readAmount(): Int {
        println("Please enter the purchase amount.")
        val input = Console.readLine()
        val amount = input.toIntOrNull() ?: throw IllegalArgumentException("[ERROR] Input must be a number.")
        if (amount % 1000 != 0) throw IllegalArgumentException("[ERROR] Amount must be divisible by 1000.")
        return amount
    }

    fun readWinningNumbers(): List<Int> {
        println("Please enter last week's winning numbers.")
        val input = Console.readLine()
        val numbers = input.split(",").map {
            it.trim().toIntOrNull() ?: throw IllegalArgumentException("[ERROR] Input must be numbers.")
        }
        if (numbers.size != 6 || numbers.toSet().size != 6 || numbers.any { it !in 1..45 })
            throw IllegalArgumentException("[ERROR] Invalid winning numbers.")
        return numbers
    }

    fun readBonusNumber(winning: List<Int>): Int {
        println("Please enter the bonus number.")
        val bonus = Console.readLine().toIntOrNull() ?: throw IllegalArgumentException("[ERROR] Must be a number.")
        if (bonus !in 1..45 || bonus in winning)
            throw IllegalArgumentException("[ERROR] Invalid bonus number.")
        return bonus
    }
}
