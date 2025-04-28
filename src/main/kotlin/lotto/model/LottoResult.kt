package lotto.model

import lotto.enums.LottoRank

class LottoResult {
    private val rankResults: MutableMap<LottoRank, Int> = mutableMapOf()

    init {
        for (rank in LottoRank.values()) {
            rankResults[rank] = 0
        }
    }

    fun compare(lottoTicket: LottoTicket, winningLotto: WinningLotto) {
        val ticketNumbers = lottoTicket.getLottoTicketNumbers()
        for (lottoNumbers in ticketNumbers) {
            val matchCount = lottoNumbers.count { winningLotto.getNumbers().contains(it) }
            val hasBonus = lottoNumbers.contains(winningLotto.getBonusNum())
            if (matchCount >= 3) {
                val rank = LottoRank.valueOfMatchCount(matchCount, hasBonus)
                rankResults[rank] = rankResults.getOrDefault(rank, 0) + 1
            }
        }
    }

    fun getRankResults(): Map<LottoRank, Int> = rankResults
}
