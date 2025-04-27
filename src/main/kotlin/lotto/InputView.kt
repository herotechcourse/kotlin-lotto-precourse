package lotto

import camp.nextstep.edu.missionutils.Console

object InputView {
    fun getPurchaseAmount(): Int {
        while (true) {
            try {
                println("Please enter the purchase amount.")
                val input = Console.readLine()
                val amount = input.toIntOrNull()
                if (amount == null) {
                    throw IllegalArgumentException("[ERROR] Invalid purchase amount.")
                }
                if (amount % 1000 != 0) {
                    throw IllegalArgumentException("[ERROR] Amount must be divisible by 1000.")
                }
                return amount
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    fun getWinningNumbers(): List<Int> {
        while (true) {
            try {
                println("Please enter last week's winning numbers.")
                val input = Console.readLine()
                val numbers = input.split(",").map {
                    val number = it.toIntOrNull()
                    if (number === null) {
                        throw IllegalArgumentException("[ERROR] Winning numbers must be integers.")
                    }
                    if (number !in 1..45) {
                        throw IllegalArgumentException("[ERROR] Lotto numbers must be between 1 and 45.")
                    }
                    number
                }
                if (numbers.size != 6) {
                    throw IllegalArgumentException("[ERROR] Lotto numbers must consist of 6 unique numbers")
                }
                return numbers
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    fun getBonusNumber(): Int {
        while (true) {
            try {
                println("Please enter the bonus number.")
                val input = Console.readLine()
                val number = input.toIntOrNull()

                if (number === null) {
                    throw IllegalArgumentException("[ERROR] Invalid bonus number.")
                }
                if (number !in 1..45) {
                    throw IllegalArgumentException("[ERROR] Bonus number must be between 1 and 45.")
                }
                return number
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }
}