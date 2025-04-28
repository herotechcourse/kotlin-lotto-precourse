package lotto.view.input

import camp.nextstep.edu.missionutils.Console

object BonusNumberInputView : InputView {
    override fun readInput(): String {
        println("Please enter the bonus number.")

        return Console.readLine()
    }
}