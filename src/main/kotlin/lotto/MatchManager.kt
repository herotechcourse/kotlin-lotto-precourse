package lotto

object MatchManager {
    private var winningNumberSet: Set<Int> = emptySet()
    var bonusNumber: Int? = null

    fun init(matches: Array<Int>, bonus: Int?) {
        winningNumberSet = matches.toSet()
        bonusNumber = bonus
    }

    fun countMatches(list: List<Int>): Int {
        return winningNumberSet.intersect(list.toSet()).size
    }

    fun containsBonus(list: List<Int>): Boolean {
        return list.contains(bonusNumber)
    }
}