package lotto.view

import camp.nextstep.edu.missionutils.Console

object InputView {
    fun promptAndReadLine(promptMessage: String): String {
        println(promptMessage)
        return Console.readLine()
    }
}