package lotto


class InputHandler {
    companion object {
        const val INPUT_PURCHASE_MESSAGE = "Please enter the purchase amount."
        const val LOTTO_PRICE = 1_000
        const val INPUT_NOT_DIVIDABLE = "Input must be divided by lotto amount $LOTTO_PRICE"
        const val NOT_A_VALID_NUMBER = "Please enter a valid number."
        const val NUMBER_NOT_POSITIVE = "Please enter a positive number."
        const val INVALID_INPUT = "Invalid input."
        const val UNEXPECTED_MESSAGE = "Unexpected error."
    }

    fun readPurchaseAmount(readLine: () -> String): Int {
        while (true) {
            println(INPUT_PURCHASE_MESSAGE)
            return validateAmount { readLine() }
        }
    }

    private fun validateAmount(readLine: () -> String): Int {
        try {
            val amount = readLine().toInt()
            validate(amount)
            return amount
        } catch (e: Exception) {
            println(errorMessage(e))
            throw e
        }
    }

    private fun validate(purchaseAmount: Int) {
        checkDivisibility(purchaseAmount)
        checkPositive(purchaseAmount)
    }

    private fun checkDivisibility(purchaseAmount: Int) {
        if (purchaseAmount % LOTTO_PRICE != 0) {
            throw IllegalArgumentException(INPUT_NOT_DIVIDABLE)
        }
    }

    private fun checkPositive(purchaseAmount: Int) {
        if (purchaseAmount <= 0) {
            throw IllegalArgumentException(NUMBER_NOT_POSITIVE)
        }
    }

    private fun errorMessage(e: Throwable): String {
        when (e) {
            is NumberFormatException -> return NOT_A_VALID_NUMBER
            is IllegalArgumentException -> return INVALID_INPUT
            else -> return UNEXPECTED_MESSAGE
        }
    }
}