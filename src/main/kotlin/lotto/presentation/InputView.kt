package lotto.presentation

import camp.nextstep.edu.missionutils.Console

interface InputView {
    fun readPurchaseAmount(): String
    fun readWinningNumbers(): String
}

class InputViewImpl : InputView {

    override fun readPurchaseAmount(): String {
        return Console.readLine()
    }

    override fun readWinningNumbers(): String {
        return Console.readLine()
    }

}
