package lotto.io

import camp.nextstep.edu.missionutils.Console

object InputHandler {
    fun getSumOfMoney(): Int {
        println("Please enter the purchase amount.")
        return Console.readLine()?.toIntOrNull()
            ?: throw IllegalArgumentException("[ERROR] The purchase amount should be an integer.")
    }

    fun getWinningNumbers(): List<Int> {
        println("Please enter last week's winning numbers.")
        return Console.readLine().split(",").map {
            it.trim().toIntOrNull()
                ?: throw IllegalArgumentException("[ERROR] The winning number should be an integer.")
        }
    }

    fun getBonusNumber(): Int {
        println("Please enter the bonus number.")
        return Console.readLine()?.toIntOrNull()
            ?: throw IllegalArgumentException("The purchase amount should be an integer.")
    }
}
