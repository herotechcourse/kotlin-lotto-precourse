package lotto

import camp.nextstep.edu.missionutils.Console

class InputView {

    fun read(prompt: String): String{
        println(prompt)
        return Console.readLine()
    }
}