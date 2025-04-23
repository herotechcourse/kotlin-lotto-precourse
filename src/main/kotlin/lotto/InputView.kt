package lotto

import camp.nextstep.edu.missionutils.Console

class InputView {
    fun purchaseAmount() : String {
        val input = Console.readLine()
        return input
    }
}