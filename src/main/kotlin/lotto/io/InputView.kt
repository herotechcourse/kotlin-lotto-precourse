package lotto.io

import camp.nextstep.edu.missionutils.Console

object InputView {

    fun readPurchaseAmount(): Int {
        while (true) {
            println("Please enter the purchase amount.")
            val input = Console.readLine()
            println()

            try {
                return InputParser.parsePurchaseAmount(input)
            }catch (e : IllegalArgumentException){
                println(e.message)
            }
        }
    }

}