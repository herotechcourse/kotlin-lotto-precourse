package lotto.view

import camp.nextstep.edu.missionutils.Console

object InputView {
    fun promptAndReadLine(promptMessage: String): String {
        println(promptMessage)
        return try {
            Console.readLine()
        } catch (e: NoSuchElementException) {
            throw IllegalStateException("[ERROR] Unexpected end of input (EOF).")
        }
    }
}