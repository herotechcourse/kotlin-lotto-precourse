package lotto

class WinningLotto(
    numbers: List<Int>,
    private val bonusNumber: Int,
) {
    private val minNumber = Config.MIN_LOTTO_NUMBER
    private val maxNumber = Config.MAX_LOTTO_NUMBER
    private val ticket = Lotto(numbers)

    init {
        require(bonusNumber in minNumber..maxNumber) { "[ERROR] Bonus number must be in between $minNumber and $maxNumber." }
        require(!numbers.contains(bonusNumber)) { "[ERROR] Bonus number must not a duplicated from the winning numbers." }
    }

    fun matchCount(lotto: Lotto): Int {
        return lotto.getNumbers().count { it in ticket.getNumbers() }
    }

    fun isMatchBonusNumber(lotto: Lotto): Boolean {
        return bonusNumber in lotto.getNumbers()
    }

    fun match(lotto: Lotto): Rank {
        val matchCount = matchCount(lotto)
        val isMatchBonus = isMatchBonusNumber(lotto)
        return Rank.matching(matchCount, isMatchBonus)
    }
}