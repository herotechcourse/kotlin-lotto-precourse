package lotto.utils

import lotto.exception.LottoInputException

object Utils {
    /**
     * Retries the input until it is valid, as per the block's logic.
     * This function catches and handles [LottoInputException] to prompt the user for valid input.
     */
    fun <T> retryInputUntilSuccess(block: () -> T): T {
        while (true) {
            try {
                return block() // Retry input until it succeeds
            } catch (e: LottoInputException) {
                println(e.message)
                println()
            }
        }
    }
}