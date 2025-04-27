package lotto.domain

class LottoTicket(val lotto: Lotto) {
    fun matchCount(winningNumbers: Set<Int>): Int {
        return lotto.getNumbers().count { it in winningNumbers }
    }

    fun containsBonus(bonus: Int): Boolean {
        return bonus in lotto.getNumbers()
    }
}

