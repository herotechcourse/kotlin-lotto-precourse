package lotto.presentation

import camp.nextstep.edu.missionutils.Console

interface InputView {
    fun readPurchaseAmount(): String
    fun readWinningNumbers(): String
    fun readBonusNumber(): String
}

class InputViewImpl : InputView {

    override fun readPurchaseAmount(): String {
        return Console.readLine()
    }

    override fun readWinningNumbers(): String {
        return Console.readLine()
    }

    override fun readBonusNumber(): String {
        return Console.readLine()
    }

}
