package lotto

import camp.nextstep.edu.missionutils.Console

object InputView {
    fun readPurchaseAmount(): Int {
        println("Please enter the purchase amount.")
        val input = Console.readLine()
        return input.toIntOrNull()
            ?.takeIf { it % 1000 == 0 }
            ?: throw IllegalArgumentException("[ERROR] Amount must be a multiple of 1000.")
    }

    fun readWinningNumbers(): List<Int> {
        println("Please enter last week's winning numbers.")
        val input = Console.readLine()
        return input.split(",")
            .map { it.trim().toInt() }
            .also {
                require(it.size == 6) { "[ERROR] You must enter exactly 6 numbers." }
                require(it.distinct().size == 6) { "[ERROR] Numbers must be unique." }
                require(it.all { num -> num in 1..45 }) { "[ERROR] Lotto numbers must be between 1 and 45." }
            }
    }

    fun readBonusNumber(): Int {
        println("Please enter the bonus number.")
        val input = Console.readLine()
        val bonus = input.toIntOrNull() ?: throw IllegalArgumentException("[ERROR] Invalid number.")
        require(bonus in 1..45) { "[ERROR] Lotto numbers must be between 1 and 45." }
        return bonus
    }
}
