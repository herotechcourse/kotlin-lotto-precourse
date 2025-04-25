package lotto

import camp.nextstep.edu.missionutils.Console

object InputView {
    fun getPurchaseAmount(): Int {
        println("Please enter the purchase amount:")
        val purchaseAmountInput = Console.readLine()
        val purchaseAmount = purchaseAmountInput.toIntOrNull()
        return purchaseAmount?.takeIf { it > 0 && it % 1000 == 0 }
            ?: throw IllegalArgumentException("Amount must be a positive number that is divisible by 1000")
    }
}