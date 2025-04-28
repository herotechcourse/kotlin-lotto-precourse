package lotto

import camp.nextstep.edu.missionutils.Console

class InputView(private val outputView: OutputView) {
    fun readPurchaseAmount(): String {
        outputView.promptPurchase()
        return Console.readLine()
    }

    fun readWinningNumbers(): String {
        outputView.promptWinningNumbers()
        return Console.readLine()
    }

    fun readBonusNumber(): String {
        outputView.promptBonusNumber()
        return Console.readLine()
    }
}