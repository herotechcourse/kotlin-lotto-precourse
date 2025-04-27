package lotto

import camp.nextstep.edu.missionutils.Console

class InputView {
    fun readPurchaseAmount(): Int {
        println("Please enter the purchase amount.")
        val input = Console.readLine()
        val amount = input.toIntOrNull() ?: throw IllegalArgumentException("[ERROR] Please enter a valid number.")
        require(amount > 0) { "[ERROR] Purchase amount must be positive." }
        require(amount % 1000 == 0) { "[ERROR] Purchase amount must be divisible by 1,000." }
        return amount
    }

    fun readWinningNumbers(): List<Int> {
        println("\nPlease enter last week's winning numbers.")
        val input = Console.readLine()
        return input.split(",")
            .map { it.trim() }
            .map { it.toIntOrNull() ?: throw IllegalArgumentException("[ERROR] Please enter valid numbers.") }
            .also { numbers ->
                require(numbers.size == 6) { "[ERROR] Please enter exactly 6 numbers." }
                require(numbers.all { it in 1..45 }) { "[ERROR] Lotto numbers must be between 1 and 45." }
                require(numbers.toSet().size == 6) { "[ERROR] Numbers must be unique." }
            }
    }

    fun readBonusNumber(winningNumbers: List<Int>): Int {
        println("\nPlease enter the bonus number.")
        val input = Console.readLine()
        val number = input.toIntOrNull() ?: throw IllegalArgumentException("[ERROR] Please enter a valid number.")
        require(number in 1..45) { "[ERROR] Bonus number must be between 1 and 45." }
        require(number !in winningNumbers) { "[ERROR] Bonus number must not be in winning numbers." }
        return number
    }
} 