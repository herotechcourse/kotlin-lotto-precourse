package lotto.view

import camp.nextstep.edu.missionutils.Console

object InputView {
    fun readPurchaseAmount(): Int {
        println("Please enter the purchase amount.")
        val input = Console.readLine()
        val purchaseAmount = input.toIntOrNull() ?: throw IllegalArgumentException("[ERROR] Please enter a valid number.")

        if (purchaseAmount % 1000 != 0) {
            throw IllegalArgumentException("[ERROR] The purchase amount must be divisible by 1000.")
        }
        return purchaseAmount
    }
}

