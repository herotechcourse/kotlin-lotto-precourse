package lotto.view

import camp.nextstep.edu.missionutils.Console

object InputView {
    private const val PURCHASE_AMOUNT_MESSAGE : String = "Please enter the purchase amount."

    fun readPurchaseAmount(){
        println(PURCHASE_AMOUNT_MESSAGE)

        val purchaseAmount = Console.readLine()
    }
}