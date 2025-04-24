package lotto.input

import camp.nextstep.edu.missionutils.Console

class WinningNumberInputReader {
    fun read(): String {
        println("Please enter last week's winning numbers.")
        return Console.readLine()
    }
}