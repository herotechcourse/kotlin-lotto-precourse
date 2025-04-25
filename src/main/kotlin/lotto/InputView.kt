package lotto

import camp.nextstep.edu.missionutils.Console

class InputView {
    private var _winningNumbers = listOf<Int>()

    fun readPurchaseAmount(): Int {
        repeat(MAX_RETRY) {
            try {
                println("\nPlease enter the purchase amount:")
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
        require(amount % TICKET_PRICE == 0) {
            DIVISIBLE_AMOUNT_MSG
        }
        require(amount in 1..MAX_AMOUNT) {
            AMOUNT_RANGE_MSG
        }
        return amount
    }

    fun readWinningNumbers(): List<Int> {
        repeat(MAX_RETRY) {
            try {
                println("\nPlease enter the winning numbers (comma-separated):")
                val input = Console.readLine()
                _winningNumbers = input.split(',').map(String::toInt)
                return parseWinningNumbers(input)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
        throw MaxRetryException(MAX_RETRY_MSG)
    }

    internal fun parseWinningNumbers(input: String): List<Int> {
        val rawNumbers = input.split(",").map { it.trim().toIntOrNull() }
        require(rawNumbers.all { it != null } ) { INVALID_INPUT_MSG }
        val numbers = rawNumbers.map { it!! } // casting from List<Int?> to List<Int>
        require(numbers.size == LOTTO_SIZE) { LOTTO_SIZE_MSG }
        require(numbers.distinct().size == numbers.size) { UNIQUE_NUM_MSG }
        numbers.forEach {
                number -> require(number in MIN_NUM..MAX_NUM) { INVALID_RANGE_MSG }
        }
        _winningNumbers = numbers
        return numbers
    }

    fun readBonusNumber(): Int {
        repeat(MAX_RETRY) {
            try {
                println("\nPlease enter a bonus number:")
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
        require(number in MIN_NUM..MAX_NUM) { INVALID_RANGE_MSG }
        require(number !in _winningNumbers) { UNIQUE_BONUS_MESSAGE }
        return number
    }

    // TODO make it private or extract it to be used by Lotto class
    companion object {
        private const val MAX_RETRY = 5
        private const val MIN_NUM = 1
        private const val MAX_NUM = 45
        private const val MAX_AMOUNT = 15000
        private const val LOTTO_SIZE = 6
        private const val TICKET_PRICE = 1000
        private const val AMOUNT_RANGE_MSG = "[ERROR] Amount cannot be 0 or higher than $MAX_AMOUNT"
        private const val MAX_RETRY_MSG = "[ERROR] Maximum retry attempts exceeded."
        private const val INVALID_INPUT_MSG = "[ERROR] Invalid input."
        private const val DIVISIBLE_AMOUNT_MSG = "[ERROR] Amount has to be divisible by $TICKET_PRICE."
        private const val INVALID_RANGE_MSG = "[ERROR] Invalid number: not in range $MIN_NUM-$MAX_NUM."
        private const val UNIQUE_NUM_MSG = "[ERROR] Input must contain unique numbers."
        private const val LOTTO_SIZE_MSG =  "[ERROR] Input must contain exactly $LOTTO_SIZE numbers."
        private const val UNIQUE_BONUS_MESSAGE = "[ERROR] Bonus number has to differ from the winning numbers."
    }

    class MaxRetryException(message: String, cause: Throwable? = null): RuntimeException(message, cause)
}