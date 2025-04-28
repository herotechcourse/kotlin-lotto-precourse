package lotto.domain

import lotto.Lotto

object LottoResult {
    fun checkResult(tickets: List<Lotto>, winningLotto: WinningLotto): PrizeResult {
        val prizeResult = PrizeResult()
        tickets.forEach { ticket ->
            val rank = determineRank(ticket, winningLotto)
            prizeResult.add(rank)
        }
        return prizeResult
    }

    private fun determineRank(ticket: Lotto, winningLotto: WinningLotto): Rank {
        val numbers = ticket.getNumbers()
        val matchCount = numbers.count { it in winningLotto.ticket }
        val bonusMatched = winningLotto.bonus in numbers
        return Rank.of(matchCount, bonusMatched)
    }

}