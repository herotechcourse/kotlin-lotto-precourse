package lotto

class WinningLotto(
    private val winningLotto: Lotto,
    private val bonusNumber: Int
) {
    init {
        require(bonusNumber in NUMBER_RANGE) { "Bonus number must be between ${NUMBER_RANGE.first} and ${NUMBER_RANGE.last}." }
        require(bonusNumber !in winningLotto.getNumbers()) { "Bonus number must not be included in the winning numbers." }
    }

    fun match(lotto: Lotto): Rank {
        val matchCount: Int = lotto.matchCount(winningLotto)
        val bonusMatch: Boolean = lotto.contains(bonusNumber)

        return Rank.of(matchCount, bonusMatch)
    }

    companion object {
        private val NUMBER_RANGE = 1..45
    }
}
