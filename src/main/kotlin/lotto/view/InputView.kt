package lotto.view

import camp.nextstep.edu.missionutils.Console

object InputView {
    fun promptAndReadLine(promptMessage: String): String {
        OutputView.message(promptMessage)
        return Console.readLine()
    }
}