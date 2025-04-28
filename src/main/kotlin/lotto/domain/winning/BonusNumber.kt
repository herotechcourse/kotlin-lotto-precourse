package lotto.domain.winning

import lotto.Lotto

class BonusNumber(private val number: Int) {
    init {
        require(isValidRange(number)) { "[ERROR] Winning numbers must be between $START_INCLUSIVE and $END_INCLUSIVE." }
    }

    private fun isValidRange(number: Int): Boolean {
        return number in START_INCLUSIVE..END_INCLUSIVE
    }

    fun isMatched(randomLotto: Lotto): Boolean = randomLotto.numbers().contains(number)

    companion object {
        private const val START_INCLUSIVE = 1
        private const val END_INCLUSIVE = 45

        fun from(number: Int, numbers: WinningNumbers): BonusNumber {
            require(numbers.doNotContain(number)) { "[ERROR] bonus number must not be duplicated with winning numbers." }
            return BonusNumber(number)
        }
    }
}