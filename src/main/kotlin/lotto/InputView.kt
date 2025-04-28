package lotto

import camp.nextstep.edu.missionutils.Console

object InputView {

    fun readPurchaseAmount(): String {
        println("Please enter the purchase amount.")
        return Console.readLine()
    }
}
