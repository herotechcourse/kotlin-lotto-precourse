package lotto.ui.console

import camp.nextstep.edu.missionutils.Console

class ConsoleIO : ConsoleIOInterface {
    override fun read(): String {
        return Console.readLine()
    }
    override fun print(message: String) {
        println(message)
    }
}