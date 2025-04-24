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
        require(amount in 1..MAX_AMOUNT) {
            AMOUNT_RANGE_MSG
        }
        // add a max value e.g. 10.000
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
        const val MAX_AMOUNT = 15000
        const val AMOUNT_RANGE_MSG = "[ERROR] Amount cannot be 0 or higher than $MAX_AMOUNT"
        const val MAX_RETRY_MSG = "[ERROR] Maximum retry attempts exceeded."
        const val INVALID_INPUT_MSG = "[ERROR] Invalid input."
        const val DIVISIBLE_AMOUNT_MSG = "[ERROR] Amount has to be divisible by 1000."
        const val INVALID_RANGE_MSG = "[ERROR] Invalid number: not in range $MIN_NUM-$MAX_NUM."
    }

    class MaxRetryException(message: String, cause: Throwable? = null): RuntimeException(message, cause)
}