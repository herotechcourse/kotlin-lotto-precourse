package lotto.view

import camp.nextstep.edu.missionutils.Console

object InputView {

    fun getPurchaseAmount(): Int {
        return retryUntilValid(::readPurchaseAmount)
    }

    fun readPurchaseAmount(): Int {
        println("Please enter the purchase amount!")
        val amount = Console.readLine().trim()
        return validatePurchaseAmount(amount)
    }

    private fun validatePurchaseAmount(input: String): Int {
        val amount = input.toIntOrNull()
            ?: throw IllegalArgumentException("[ERROR] Invalid input. Please enter a valid integer.")
        require(amount >= 1000 && amount % 1000 == 0) {
            "[ERROR] Purchase amount must be a multiple of 1,000."
        }
        return amount
    }

    private fun <T> retryUntilValid(block: () -> T): T {
        while (true) {
            try {
                return block()
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }
}