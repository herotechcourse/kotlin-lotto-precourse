package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.util.InputValidator

class InputView {
    private fun readLine(prompt: String): String? {
        println(prompt)
        return Console.readLine()
    }

    fun readAmount(): String? {
        val amount = readLine("Please enter the purchase amount.")
        return amount
    }

    fun readWinningNumbers(): String? {
        val winningNums = readLine("\nPlease enter last week's winning numbers.")
        return winningNums
    }

    fun readBonusNumber(): String? {
        val bonusNum = readLine("\nPlease enter the bonus number.")
        return bonusNum
    }
}