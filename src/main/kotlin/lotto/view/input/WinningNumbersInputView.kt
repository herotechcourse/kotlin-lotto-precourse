package lotto.view.input

import camp.nextstep.edu.missionutils.Console

object WinningNumbersInputView {
    fun inputWinningNumbers(): List<String> {
        println("Please enter last week's winning numbers.")
        return Console.readLine().split(",")
    }
}
