package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] Lotto must contain exactly 6 numbers." }
    }

    fun showNumbers() {
        println(numbers)
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

