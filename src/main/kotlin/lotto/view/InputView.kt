package lotto.view

import camp.nextstep.edu.missionutils.Console

object InputView {

    fun readPurchaeAmount(): Int {
        println("Please enter the purchase amoung.")
        val input = Console.readLine()

        val amount = input.toIntOrNull()
            ?: throw IllegalArgumentException("[ERROR] Please enter a valid integer.")

        if(amount % 1000 != 0){
            throw IllegalArgumentException("[ERROR] Amount must be divisible by 1,000.")
        }

        return amount
    }

    fun readWinningNumbers(): List<Int> {
        println("Please enter last week's winning numbers.")
        val input = Console.readLine()

        val numbers = input.split(",")
            .map { it.trim() }
            .map {
                it.toIntOrNull() ?: throw IllegalArgumentException("[ERROR] Please enter valid integers.")
            }

        return numbers
    }

    fun readBonusNumber(): Int {
        println("Please enter the bonus number.")
        val input = Console.readLine()

        return input.toIntOrNull()?.takeIf { it in 1..45 }
            ?: throw IllegalArgumentException("[ERROR] Bonus number must be an integer between 1 and 45.")
    }

}