package lotto

import camp.nextstep.edu.missionutils.Console

class InputParamsReader {
    private val validator = PurchaseAmountValidator()

    fun retrievePurchaseAmountWithRetry(): Int {
        while (true) {
            try {
                return retrievePurchaseAmount()
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    private fun retrievePurchaseAmount(): Int {
        val input = Console.readLine()
        val amount = input.toIntOrNull()
        validator.validatePurchaseAmount(amount)
        return amount!!
    }
}