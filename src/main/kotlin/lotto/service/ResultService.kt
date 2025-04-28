package lotto.service

import lotto.Lotto
import lotto.domain.WinningNumbers
import lotto.domain.PrizeRank
import lotto.domain.LottoResult

/**
 * Service responsible for evaluating lottery tickets against winning numbers.
 */
object ResultService {
    /**
     * Evaluates a lottery ticket against winning numbers to determine the prize rank.
     */
    fun evaluateTicket(ticket: Lotto, winningNumbers: WinningNumbers): LottoResult {
        val matchedNumbers = ticket.getNumbers().intersect(winningNumbers.getNumbers()).toList()
        val hasBonus = ticket.getNumbers().contains(winningNumbers.getBonusNumber())
        val prizeRank = PrizeRank.findByMatch(matchedNumbers.size, hasBonus)

        return LottoResult(ticket, prizeRank, matchedNumbers, hasBonus)
    }
}