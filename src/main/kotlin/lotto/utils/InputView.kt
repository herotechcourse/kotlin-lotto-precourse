package lotto.utils

import camp.nextstep.edu.missionutils.Console

object InputView {
    fun readPurchaseAmount(): Int {

        while (true) {
            try {
                println("Please enter the purchase amount.")
                val input = Console.readLine() ?: throw IllegalArgumentException("[ERROR] Input cannot be empty.")

                if (input.isBlank()) throw IllegalArgumentException("[ERROR] Input cannot be empty.")

                val amount = input.toIntOrNull() ?: throw NumberFormatException("[ERROR] Input must be a number.")

                if (amount <= 0) throw IllegalArgumentException("[ERROR] The purchase amount must be greater than 0.")

                require(amount % 1000 == 0) { "[ERROR] The purchase amount must be divisible by 1,000." }
                return amount
            } catch (e: IllegalArgumentException) {
                println(e.message)
            } catch (e: NumberFormatException) {
                println("[ERROR] Input must be a number.")
            }

        }
    }
}