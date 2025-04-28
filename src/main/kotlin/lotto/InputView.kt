package lotto

import camp.nextstep.edu.missionutils.Console

class InputView {
    fun readAmount(): Int {
        println("Please enter the purchase amount.")
        val amount = Console.readLine().toInt()
        return amount
    }

    fun readWinningNumbers() : List<Int> {
        println("Please enter last week's winning numbers.")
        val winningNumbers = Console.readLine().split(",").map { it.toInt() }
        return winningNumbers
    }

    fun readBonusNumber() : Int{
        println("Please enter the bonus number.")
        val bonusNumber = Console.readLine().toInt()
        return bonusNumber
    }
}