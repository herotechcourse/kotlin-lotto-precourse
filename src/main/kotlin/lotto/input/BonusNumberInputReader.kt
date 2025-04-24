package lotto.input

import camp.nextstep.edu.missionutils.Console

class BonusNumberInputReader {
    fun read(): String {
        println("Please enter the bonus number.")
        return Console.readLine()
    }
}