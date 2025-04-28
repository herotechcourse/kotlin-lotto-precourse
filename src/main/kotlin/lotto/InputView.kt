package lotto

import camp.nextstep.edu.missionutils.Console

object InputView {
    fun readPurchaseAmount(): Int {
        while (true) {
            try {
                println("Please enter the purchase amount.")
                val input = Console.readLine()
                val amount = input.toIntOrNull() ?: throw IllegalArgumentException("[ERROR] Please enter a valid number.")

                if (amount <= 0) {
                    throw IllegalArgumentException("[ERROR] Amount must be positive.")
                }
                if (amount % 1000 != 0) {
                    throw IllegalArgumentException("[ERROR] Amount must be divisible by 1,000.")
                }
                return amount
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }
}
