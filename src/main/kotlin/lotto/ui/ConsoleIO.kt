package lotto.ui

import camp.nextstep.edu.missionutils.Console

class ConsoleIO : ConsoleIoInterface{
    override fun read(): String {
        return Console.readLine()
    }
    override fun print(message: String) {
        println(message)
    }
}