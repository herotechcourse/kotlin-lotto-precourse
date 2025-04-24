package lotto

import camp.nextstep.edu.missionutils.Console

class InputView {
    fun readPurchaseAmount(): Int {
        repeat(MAX_RETRY) {
            try {
                println("Please enter the purchase amount:")
                val input = Console.readLine()
                return parseAmount(input)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
        throw MaxRetryException(MAX_RETRY_MSG)
    }

    internal fun parseAmount(input: String): Int {
        val amount = input.toIntOrNull()
            ?: throw IllegalArgumentException(INVALID_AMOUNT_MSG)
        require(amount % 1000 == 0) {
            DIVISIBLE_AMOUNT_MSG
        }
        require(amount != 0) {
            ZERO_AMOUNT_MSG
        }
        return amount
    }

    fun readWinningNumbers() {}

    fun readBonusNumber() {}

    companion object {
        const val MAX_RETRY = 5
        const val MAX_RETRY_MSG = "\u001b[31m[ERROR] Maximum retry attempts exceeded.\u001b[0m"
        const val INVALID_AMOUNT_MSG = "\u001B[31m[ERROR] Invalid input.\u001b[0m"
        const val ZERO_AMOUNT_MSG = "\u001B[31m[ERROR] Amount cannot be zero.\u001B[0m"
        const val DIVISIBLE_AMOUNT_MSG = "\u001B[31m[ERROR] Amount has to be divisible by 1000.\u001b[0m"
    }

    class MaxRetryException(message: String, cause: Throwable? = null): RuntimeException(message, cause)
}