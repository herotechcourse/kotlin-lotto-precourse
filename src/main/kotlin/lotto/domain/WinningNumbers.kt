package lotto.domain

import lotto.LottoConstants.MAX_NUMBER
import lotto.LottoConstants.MIN_NUMBER
import lotto.LottoConstants.NUMBERS_PER_TICKET
import lotto.domain.ErrorMessages.INVALID_NUMBERS_RANGE
import lotto.domain.ErrorMessages.INVALID_WINNING_NUMBERS_DUPLICATED
import lotto.domain.ErrorMessages.INVALID_WINNING_NUMBERS_SIZE

data class WinningNumbers(val numbers: List<Int>) {
    init {
        require(numbers.size == NUMBERS_PER_TICKET) { INVALID_WINNING_NUMBERS_SIZE }

        require(numbers.distinct().size == NUMBERS_PER_TICKET) { INVALID_WINNING_NUMBERS_DUPLICATED }

        numbers.forEach {
            require(it in MIN_NUMBER..MAX_NUMBER) { INVALID_NUMBERS_RANGE }
        }
    }
}
