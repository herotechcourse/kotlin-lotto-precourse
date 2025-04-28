package lotto.view

import camp.nextstep.edu.missionutils.Console

class InputView() {

    fun readOneLine(prompt: String): String {
        println(prompt)
        return Console.readLine()
    }
}