package lotto

import camp.nextstep.edu.missionutils.Console

object InputView {

    fun readPurchaseAmount(): Int {
    println("Please enter the purchase amount.")
    while (true) {
        val input = Console.readLine()
        try {
            val amount = input.toInt()
            require(amount > 0) { "[ERROR] Amount must be positive." }
            require(amount % 1000 == 0) { "[ERROR] Amount must be divisible by 1000." }
            return amount
        } catch (e: Exception) {
            println("[ERROR] Invalid amount input.")
        }
    }
}


    fun readWinningNumbers(): List<Int> {
        println("Please enter last week's winning numbers.")
        val input = Console.readLine()
        val numbers = input.split(",").map {
            it.trim().toIntOrNull() ?: throw IllegalArgumentException("[ERROR] Invalid number format.")
        }
        require(numbers.size == 6) { "[ERROR] Winning numbers must consist of exactly 6 numbers." }
        require(numbers.distinct().size == 6) { "[ERROR] Winning numbers must be unique." }
        return numbers
    }

    fun readBonusNumber(): Int {
        println("Please enter the bonus number.")
        val input = Console.readLine()
        return input.toIntOrNull()
            ?: throw IllegalArgumentException("[ERROR] Invalid bonus number format.")
    }
}
