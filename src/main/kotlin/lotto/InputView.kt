package lotto

import camp.nextstep.edu.missionutils.Console

class InputView {
    fun lastWeekWinningNumbers(): String {
        val input = Console.readLine()
        return input
    }

    fun purchaseAmount() : String {
        val input = Console.readLine()
        return input
    }
}