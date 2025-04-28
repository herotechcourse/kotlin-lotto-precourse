package lotto

object MatchManager {
    private var winningNumberSet: Set<Int> = emptySet()
    var bonusNumber: Int? = null

    fun init(matches: Array<Int>, bonus: Int?) {
        winningNumberSet = matches.toSet()
        bonusNumber = bonus
    }

    fun countMatches(lotto: Lotto): Int {
        return winningNumberSet.intersect(lotto.getNumbers().toSet()).size
    }

    fun containsBonus(lotto: Lotto): Boolean {
        return lotto.getNumbers().contains(bonusNumber)
    }
}