package lotto.view

import camp.nextstep.edu.missionutils.Console

class InputView {
    fun getBudget(): String {
        println("Please enter the purchase amount.")
        val budget = Console.readLine()
        return budget
    }

    fun getWinnings(): String {
        println("Please enter last week's winning numbers.")
        val winnings = Console.readLine()

        return winnings
    }

    fun getBonusNumber(): String {
        println("Please enter the bonus number.")
        val bonus = Console.readLine()

        return bonus
    }
 }