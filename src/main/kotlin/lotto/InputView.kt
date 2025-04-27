package lotto

import camp.nextstep.edu.missionutils.Console

interface LottoInputView {
    fun getPurchaseAmount(): String
    fun getWinningNumbersInput(): String
    fun getBonusNumberInput(): String
}

class InputView : LottoInputView {
    override fun getPurchaseAmount(): String {
        println("Please enter the purchase amount.")
        return Console.readLine()
    }

    override fun getWinningNumbersInput(): String {
        println("Please enter last week's winning numbers.")
        return Console.readLine()
    }

    override fun getBonusNumberInput(): String {
        println("Please enter the bonus number.")
        return Console.readLine()
    }
}