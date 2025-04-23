package lotto

import camp.nextstep.edu.missionutils.Console

class InputView {
    /**
     * Repeatedly reads and returns a valid purchase amount from user input.
     * Only accepts values >= 1000 and divisible by 1000.
     */
    fun readValidPurchaseAmount(): Int {
        while (true) {
            try {
                return readPurchaseAmount()
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    /**
     * Reads a raw purchase amount and validates it.
     * Throws if input is not a number or invalid amount.
     */
    private fun readPurchaseAmount(): Int {
        println("Please enter the purchase amount.")
        val input = Console.readLine()
        val amount = input.toIntOrNull() ?: throw IllegalArgumentException("Input must be a valid number.")
        InputValidator.validatePurchaseAmount(amount)
        return amount
    }
}
