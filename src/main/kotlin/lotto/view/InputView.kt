package lotto.view

import camp.nextstep.edu.missionutils.Console

class InputView {
    fun getBudget(): String {
        println("Please enter the purchase amount.")
        val budget = Console.readLine()
        return budget
    }

    fun getWinnings(): String {
        println("\nPlease enter last week's winning numbers.")
        val winnings = Console.readLine()

        return winnings
    }

    fun getBonusNumber(): String {
        println("\nPlease enter the bonus number.")
        val bonus = Console.readLine()

        return bonus
    }
 }