package lotto.input

import camp.nextstep.edu.missionutils.Console

class PurchaseAmountInputReader {
    fun read(): String {
        println("Please enter the purchase amount.")
        return Console.readLine()
    }
}