package lotto.business

import camp.nextstep.edu.missionutils.Randoms
import lotto.Lotto

class LottoService {
    private var winningStatistics: LinkedHashMap<LottoMatchType, Int> = linkedMapOf(
        LottoMatchType.THREE_MATCHES to 0,
        LottoMatchType.FOUR_MATCHES to 0,
        LottoMatchType.FIVE_MATCHES to 0,
        LottoMatchType.FIVE_MATCHES_BONUS to 0,
        LottoMatchType.SIX_MATCHES to 0
    )

    fun generateLottoTickets(numberOfTickets: Long): List<Lotto>{
        val lottoTickets = ArrayList<Lotto>()
        for (i in 1 .. numberOfTickets) {
            lottoTickets.add(generateSingleLottoTicket())
        }
        return lottoTickets
    }

    fun generateSingleLottoTicket(): Lotto {
        val randomTicketSequence = Randoms.pickUniqueNumbersInRange(1, 45, 6)
        return Lotto(randomTicketSequence)
    }

    fun getWinningStatistics(lottoTickets: List<Lotto>, winningLotto: Lotto, bonusNumber: Int):
            Map<LottoMatchType, Int> {
        lottoTickets.forEach { ticket ->
            val currentLottoNumbers = ticket.getNumbers()
            val matchCount = currentLottoNumbers.intersect(winningLotto.getNumbers()).size
            val matchResult = getLottoMatchType(matchCount, currentLottoNumbers, bonusNumber)

            matchResult?.let {
                winningStatistics[it] = winningStatistics.getOrDefault(it, 0) + 1
            }
        }
        return winningStatistics
    }

    private fun getLottoMatchType( matchCount: Int, ticketNumbers: List<Int>, bonusNumber: Int): LottoMatchType? {
        return when {
            matchCount == 6 -> LottoMatchType.SIX_MATCHES
            matchCount == 5 && ticketNumbers.contains(bonusNumber) -> LottoMatchType.FIVE_MATCHES_BONUS
            matchCount == 5 -> LottoMatchType.FIVE_MATCHES
            matchCount == 4 -> LottoMatchType.FOUR_MATCHES
            matchCount == 3 -> LottoMatchType.THREE_MATCHES
            else -> null
        }
    }
}