package service

import lotto.Lotto
import lotto.LottoRank
import lotto.WinningNumbers

object LottoMatchService {
    fun countMatchingNumbers(ticket: Lotto, winningNumbers: WinningNumbers): Int =
        (ticket.bitmask and winningNumbers.bitmask).countOneBits()


    fun hasBonus(ticket: Lotto,winningNumbers: WinningNumbers): Boolean =
        (ticket.bitmask and winningNumbers.bonusBitmask) != 0L

}