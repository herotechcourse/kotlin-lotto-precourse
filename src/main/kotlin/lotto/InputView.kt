package lotto

import camp.nextstep.edu.missionutils.Console


object InputView {
    fun readPurchaseAmount(): Int {
        println("Please enter the purchase amount.")
        val input = Console.readLine()

        val amount = input.toIntOrNull()
            ?: throw IllegalArgumentException("[ERROR] Input must be a valid number")

        if (amount % 10000 != 0 ) {
            throw IllegalArgumentException("[ERROR] Amount must be divisible by 1, 000. ")
        }
        return  amount
    }
}

fun readWinningNumbers(): List<Int> {
    println("Please enter the winning numbers separated by commas:")
    val input = Console.readLine()
    val numbers = input.split(",")
        .mapNotNull {it.trim().toIntOrNull()}

    if (numbers.size != 6 || numbers.toSet().size != 6) {
        throw IllegalArgumentException("[ERROR] Please enter 6 unique winning numbers.")
    }
    if (numbers.any { it !in 1..45 }) {
        throw IllegalArgumentException("[ERROR] Winning numbers must be between 1 and 45.")
    }

    return numbers
}


fun readBonusNumber (winningNumbers: List<Int>): Int {
    println("Please enter the bonus number.")
    val input = Console.readLine()
    val bonus = input.toIntOrNull()
        ?: throw IllegalArgumentException("[ERROR] The bonus number must be a valid number.")

    if (bonus in winningNumbers) {
        throw IllegalArgumentException("[ERROR] Bonus number cannot duplicate winning numbers.")
    }

    if (bonus !in 1..45) {
        throw IllegalArgumentException("[ERROR] Bonus must be a number between 1 and 45.")
    }
    return bonus
}
