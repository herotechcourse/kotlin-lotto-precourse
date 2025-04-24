package lotto

import camp.nextstep.edu.missionutils.Console

class InputView {
    fun readPurchaseAmount(): Int {
        repeat(MAX_RETRY) {
            try {
                println("Please enter the purchase amount:")
                val input = Console.readLine().trim()
                return parseAmount(input)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
        throw MaxRetryException(MAX_RETRY_MSG)
    }

    internal fun parseAmount(input: String): Int {
        val amount = input.toIntOrNull()
            ?: throw IllegalArgumentException(INVALID_INPUT_MSG)
        require(amount % 1000 == 0) {
            DIVISIBLE_AMOUNT_MSG
        }
        require(amount != 0) {
            ZERO_AMOUNT_MSG
        }
        return amount
    }

    fun readWinningNumbers(): List<Int> {
        repeat(MAX_RETRY) {
            try {
                println("Please enter the winning numbers (comma-separated):")
                val input = Console.readLine()
                return parseWinningNumbers(input)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
        throw MaxRetryException(MAX_RETRY_MSG)
    }

    internal fun parseWinningNumbers(input: String): List<Int> {
        val numbers = input.split(",").map {
            it.trim().toIntOrNull()
            ?: throw IllegalArgumentException(INVALID_INPUT_MSG)
        }
        return numbers
    }

    fun readBonusNumber(): Int {
        repeat(MAX_RETRY) {
            try {
                println("Please enter a bonus number:")
                val input = Console.readLine()
                return parseBonusNumber(input)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
        throw MaxRetryException(MAX_RETRY_MSG)
    }

    internal fun parseBonusNumber(input: String): Int {
        val number = input.trim().toIntOrNull()
            ?: throw IllegalArgumentException(INVALID_INPUT_MSG)
        require(number in MIN_NUM..MAX_NUM) {
            INVALID_RANGE_MSG
        }
        return number
    }

    // TODO make it private or extract it to be used by Lotto class
    companion object {
        const val MAX_RETRY = 5
        const val MIN_NUM = 1
        const val MAX_NUM = 45
        const val MAX_RETRY_MSG = "\u001b[31m[ERROR] Maximum retry attempts exceeded.\u001b[0m"
        const val INVALID_INPUT_MSG = "\u001B[31m[ERROR] Invalid input.\u001b[0m"
        const val ZERO_AMOUNT_MSG = "\u001B[31m[ERROR] Amount cannot be zero.\u001B[0m"
        const val DIVISIBLE_AMOUNT_MSG = "\u001B[31m[ERROR] Amount has to be divisible by 1000.\u001b[0m"
        const val INVALID_RANGE_MSG = "\u001b[31m[ERROR] Invalid number: not in range $MIN_NUM-$MAX_NUM.\u001b[0m"
    }

    class MaxRetryException(message: String, cause: Throwable? = null): RuntimeException(message, cause)
}