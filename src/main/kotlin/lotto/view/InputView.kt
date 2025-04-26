package lotto.view

import camp.nextstep.edu.missionutils.Console

class InputView {
    private val parse = InputParser()

    fun getPurchaseAmount(): Int {
        println("Please enter the purchase amount.")
        val input = Console.readLine()
        return parse.parsePurchaseAmount(input)
    }

    fun getWinningNumbers(): List<Int> {
        println("\nPlease enter last week's winning numbers.")
        val input = Console.readLine()
        return parse.parseWinningNumbers(input)
    }

    fun getBonusNumber(): Int {
        println("\nPlease enter the bonus number.")
        val input = Console.readLine()
        return parse.parseBonusNumber(input)
    }
}
