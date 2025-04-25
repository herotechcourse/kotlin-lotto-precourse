package lotto.view

import camp.nextstep.edu.missionutils.Console

class InputView {
    private fun readLine(prompt: String): String? {
        println(prompt)
        return Console.readLine()
    }

    fun readAmount(): String? {
        val amount = readLine("Please enter the purchase amount.")
        // InputValidator
        return amount
    }

    fun readWinningNumbers(): String? {
        val winningNums = readLine("Please enter last week's winning numbers.")
        // InputValidator
        return winningNums
    }

    fun readBonusNumber(): String? {
        val bonusNum = readLine("Please enter the bonus number.")
        // InputValidator
        return bonusNum
    }
}