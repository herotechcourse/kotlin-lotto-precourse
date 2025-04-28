package lotto.view.input

import camp.nextstep.edu.missionutils.Console

object WinningNumbersInputView: InputView {
    override fun readInput(): String {
        println("Please enter the winning numbers.")
        return Console.readLine()
    }
}
