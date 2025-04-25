package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.util.Validator

object InputView {

    fun readPurchaseAmount(): Int {
        println("Please enter the purchase amount.")
        val input = Console.readLine().trim()
        Validator.validateNumber(input)
        return input.toInt()
    }

    fun readWinningNumbers(): List<Int> {
        println("Please enter last week's winning numbers (comma-separated).")
        val input = Console.readLine().trim()
        val numbers = input.split(",")
            .map { it.trim() }

        numbers.forEach { Validator.validateNumber(it) }
        return numbers.map { it.toInt() }
    }

    fun readBonusNumber(): Int {
        println("Please enter the bonus number.")
        val input = Console.readLine().trim()
        Validator.validateNumber(input)
        return input.toInt()
    }
}
