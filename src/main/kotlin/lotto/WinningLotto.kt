package lotto

class WinningLotto(
    private val winningNumbers: List<Int>,
    private val bonusNumber: Int
) {
    fun match(lotto: Lotto): Rank {
        val matchCount = lotto.numbers.count { it in winningNumbers }
        val hasBonus = bonusNumber in lotto.numbers

        return Rank.find(matchCount, hasBonus)
    }
}
