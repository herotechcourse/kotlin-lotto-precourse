package lotto.domain

import lotto.InputHandler.Companion.LOTTO_NUMBER_ENDS
import lotto.InputHandler.Companion.LOTTO_NUMBER_SIZE
import lotto.InputHandler.Companion.LOTTO_NUMBER_STARTS
import lotto.InputHandler.Companion.WINNING_NUMBER_DUPLICATE
import lotto.InputHandler.Companion.WINNING_NUMBER_OVER_RANGE
import lotto.InputHandler.Companion.WINNING_NUMBER_SIZE_NOT_SIX

class WinningNumber(val numbers: List<Int>) {
    init {
        require(checkDuplicates(numbers)) { WINNING_NUMBER_DUPLICATE }
        require(checkRange(numbers)) { WINNING_NUMBER_OVER_RANGE }
        require(checkSize(numbers)) { WINNING_NUMBER_SIZE_NOT_SIX }
    }

    private fun checkDuplicates(numbers: List<Int>) = numbers.toSet().size == numbers.size

    private fun checkRange(numbers: List<Int>): Boolean {
        for (number in numbers) {
            if (number < LOTTO_NUMBER_STARTS || number > LOTTO_NUMBER_ENDS) {
                return false
            }
        }
        return true
    }

    private fun checkSize(numbers: List<Int>) = numbers.size == LOTTO_NUMBER_SIZE
}