package lotto.service

import lotto.Lotto
import lotto.domain.WinningNumbers
import lotto.domain.PrizeRank
import lotto.domain.LottoResult

object ResultService {
    fun evaluateTicket(ticket: Lotto, winningNumbers: WinningNumbers): LottoResult {
        val matchedNumbers = ticket.getNumbers().intersect(winningNumbers.getNumbers()).toList()
        val hasBonus = ticket.getNumbers().contains(winningNumbers.getBonusNumber())
        val prizeRank = when {
            matchedNumbers.size == 6 -> PrizeRank.FIRST
            matchedNumbers.size == 5 && hasBonus -> PrizeRank.SECOND
            matchedNumbers.size == 5 -> PrizeRank.THIRD
            matchedNumbers.size == 4 -> PrizeRank.FOURTH
            matchedNumbers.size == 3 -> PrizeRank.FIFTH
            else -> PrizeRank.NONE
        }

        return LottoResult(ticket, prizeRank, matchedNumbers, hasBonus)
    }
}