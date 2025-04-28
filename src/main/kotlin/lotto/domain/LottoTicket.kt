package lotto.domain

import lotto.Lotto

class LottoTicket(private val lotto: Lotto) {

   fun match(winningNumbers: List<Int>, bonusNumber: Int): Rank {
    val matchCount = lotto.getNumbers().count { it in winningNumbers }
    val bonusMatch = bonusNumber in lotto.getNumbers()
    return Rank.of(matchCount, bonusMatch)
}

    fun numbers(): List<Int> = lotto.getNumbers()
}
