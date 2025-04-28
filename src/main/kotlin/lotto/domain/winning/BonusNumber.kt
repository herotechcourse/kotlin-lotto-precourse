package lotto.domain.winning

import lotto.Lotto
import lotto.exception.DomainException

class BonusNumber(private val number: Int) {
    init {
        require(isValidRange(number)) { DomainException.MUST_BE_VALID_RANGE.format(START_INCLUSIVE, END_INCLUSIVE) }
    }

    private fun isValidRange(number: Int): Boolean {
        return number in START_INCLUSIVE..END_INCLUSIVE
    }

    fun isMatched(randomLotto: Lotto): Boolean = randomLotto.numbers().contains(number)

    companion object {
        private const val START_INCLUSIVE = 1
        private const val END_INCLUSIVE = 45

        fun from(number: Int, numbers: WinningNumbers): BonusNumber {
            require(numbers.doNotContain(number)) { DomainException.BONUS_NUMBER_IS_UNIQUE.message() }
            return BonusNumber(number)
        }
    }
}