package lotto.view

import camp.nextstep.edu.missionutils.Console

class ConsoleInputReader: InputReader {
    override fun readPurchaseAmount(): String {
        println("Please enter the purchase amount.")
        return Console.readLine()
    }

    override fun readWinningNumbers(): List<String> {
        println("Please enter the winning numbers.")
        return Console.readLine().split(",")
    }

    override fun readBonusNumber(): String{
        println("Please enter the bonus number.")
        return Console.readLine()
    }
}
