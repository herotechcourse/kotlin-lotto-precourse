package service

import lotto.Lotto
import lotto.LottoRank
import lotto.WinningNumbers

object LottoMatchService {
    fun countMatchingNumbers(ticket: Lotto, winningNumbers: WinningNumbers): Int =
        (ticket.bitmask and winningNumbers.bitmask).countOneBits()


    fun hasBonus(ticket: Lotto,winningNumbers: WinningNumbers): Boolean =
        (ticket.bitmask and winningNumbers.bonusBitmask) != 0L

    fun determineRank(matchCount:Int, hasBonus: Boolean): LottoRank? = when {
        matchCount == 6 -> LottoRank.SIX
        matchCount == 5 && hasBonus -> LottoRank.FIVE_BONUS
        matchCount == 5 -> LottoRank.FIVE
        matchCount == 4 -> LottoRank.FOUR
        matchCount == 3 -> LottoRank.THREE
        else -> null
    }

}