package lotto

import camp.nextstep.edu.missionutils.Console

object InputView {
    fun readPurchaseAmount(): Int {
        println("Please enter the purchase amount.")
        val input = Console.readLine()
        val amount = input.toIntOrNull()
        require(amount != null && amount % 1000 == 0) {
            "[ERROR] Amount must be a multiple of 1,000."
        }
        return amount
    }

    fun readWinningNumbers(): List<Int> {
        println("\nPlease enter last week's winning numbers.")
        return Console.readLine()
            .split(",")
            .map { it.trim().toIntOrNull() ?: throw IllegalArgumentException("[ERROR] Invalid number.") }
            .also {
                require(it.size == 6 && it.distinct().size == 6) { "[ERROR] 6 unique numbers required." }
                require(it.all { n -> n in 1..45 }) { "[ERROR] Lotto numbers must be 1–45." }
            }
    }

    fun readBonusNumber(winningNumbers: List<Int>): Int {
        println("\nPlease enter the bonus number.")
        val number = Console.readLine().toIntOrNull()
            ?: throw IllegalArgumentException("[ERROR] Bonus must be a number.")
        require(number in 1..45 && number !in winningNumbers) {
            "[ERROR] Bonus must be 1–45 and not in winning numbers."
        }
        return number
    }
}
