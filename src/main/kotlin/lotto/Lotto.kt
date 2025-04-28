package lotto

import lotto.validators.ValidationErrors

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { ValidationErrors.MUST_ENTER_SIX_NUMBERS.message }
        require(numbers.size == numbers.toSet().size) { ValidationErrors.MUST_ENTER_UNIQUE_NUMBERS.message }
        require(numbers.all { it in 1..45 }){ ValidationErrors.MUST_BE_IN_RANGE.message }
    }

    fun getNumbers(): List<Int>{
        return numbers
    }

    fun calculateMatches(winningCombination: List<Int>): Int {
        return numbers.filter({ value -> winningCombination.contains(value) }).size
    }

    /**
     * Bonus number logic is not define in requirements, so I assume, that we do a simple check without considering other matches.
     * However, we could also do checks excluding existing matches in advance.
     */
    fun hasBonusNumber(bonusNumber: Int): Boolean {
        return numbers.contains(bonusNumber)
    }
}

