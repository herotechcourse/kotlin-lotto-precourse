package lotto.view

import camp.nextstep.edu.missionutils.Console

object InputView {

    fun readPurchaseAmount(): Int {
        println("Please enter the purchase amount.")
        val input = Console.readLine()

        return try {
            val amount = input.toInt()
            validateAmount(amount)
            amount
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("[ERROR] Please enter a valid number.")
        }
    }

    private fun validateAmount(amount: Int) {
        if (amount <= 0 || amount % 1000 != 0) {
            throw IllegalArgumentException("[ERROR] Amount must be a positive number divisible by 1,000.")
        }
    }
}