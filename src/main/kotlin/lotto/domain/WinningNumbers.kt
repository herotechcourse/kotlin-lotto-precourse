package lotto.domain

import lotto.domain.ErrorMessages.INVALID_NUMBERS_RANGE
import lotto.domain.ErrorMessages.INVALID_WINNING_NUMBERS_DUPLICATED
import lotto.domain.ErrorMessages.INVALID_WINNING_NUMBERS_SIZE

data class WinningNumbers(val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { INVALID_WINNING_NUMBERS_SIZE }

        require(numbers.distinct().size == 6) { INVALID_WINNING_NUMBERS_DUPLICATED }

        numbers.forEach {
            require(it in 1..45) { INVALID_NUMBERS_RANGE }
        }
    }
}
