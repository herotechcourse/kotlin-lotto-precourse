package lotto

import camp.nextstep.edu.missionutils.Console

object InputHandler {

    private const val PURCHASE_AMOUNT_DIVISOR = 1000

    fun readAndValidatePurchaseAmount(): Int {
        do {
            println("Please enter the purchase amount.")
            val input = Console.readLine()
            try {
                return parsePurchaseAmount(input)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        } while (true)
    }

    private fun parsePurchaseAmount(input: String): Int {
        val amount = input.toIntOrNull()
        if (amount == null || amount % PURCHASE_AMOUNT_DIVISOR != 0) {
            throw IllegalArgumentException("[ERROR] Amount must be a valid integer divisible by 1000.")
        }
        return amount
    }
}
