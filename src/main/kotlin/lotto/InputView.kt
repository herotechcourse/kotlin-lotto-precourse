package lotto

import camp.nextstep.edu.missionutils.Console

class InputView {
    fun getPurchaseAmount():Int {
        println("Please Enter Purchase amount for lottery tickets:")
        val input=Console.readLine()
        val purchaseAmount = input?.toIntOrNull()?:throw IllegalArgumentException("Invalid Input :not a number")
        if (purchaseAmount >= 0 && purchaseAmount % 1000 == 0) {
            return purchaseAmount
        }
        throw IllegalArgumentException()
    }
}

