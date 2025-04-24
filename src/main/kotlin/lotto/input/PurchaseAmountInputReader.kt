package lotto.input

import camp.nextstep.edu.missionutils.Console

import lotto.validation.PurchaseAmountValidator

private val validator = PurchaseAmountValidator()

class PurchaseAmountInputReader {

    fun read(): Int {
        while (true) {
            println("Please enter the purchase amount.")
            val input = Console.readLine()
            try {
                return validator.validatePurchaseAmount(input)  //Return Valid input
            } catch (e: IllegalArgumentException) {
                println(e.message)                              //Otherwise, print error message
            }
        }
    }
}