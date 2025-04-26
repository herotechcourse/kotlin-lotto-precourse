package lotto.view

import camp.nextstep.edu.missionutils.Console

class InputView {
    private val parse = InputParser()

    fun getPurchaseAmount(): Int {
        println("Please enter the purchase amount.")
        val readLine = Console.readLine()
        return parse.parsePurchaseAmount(readLine)
    }
}
