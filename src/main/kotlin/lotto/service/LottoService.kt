package lotto.service

import camp.nextstep.edu.missionutils.Randoms
import lotto.Lotto
import lotto.model.MatchResult
import lotto.model.WinningNumbers
import lotto.util.PrizeRank
import lotto.util.Rule

class LottoService {
    fun purchaseLottoTickets(amount: Int): List<Lotto> {
        val ticketCount = amount / Rule.LOTTO_PRICE
        return List(ticketCount) {
            val numbers = Randoms.pickUniqueNumbersInRange(Rule.MIN_NUMBER, Rule.MAX_NUMBER, Rule.NUMBERS_COUNT)
            Lotto(numbers)
        }
    }

    fun determineWinningResults(lottoTickets: List<Lotto>, winningNumbers: WinningNumbers): MatchResult {
        val rankCounts = mutableMapOf<PrizeRank, Int>().withDefault { 0 }
        var totalPrize = 0

        lottoTickets.forEach { ticket ->
            val matchCount = ticket.countMatching(winningNumbers.numbers)
            val hasBonus = ticket.contains(winningNumbers.bonusNumber)
            val rank = PrizeRank.determineRank(matchCount, hasBonus)
            rankCounts[rank] = rankCounts.getValue(rank)+1
            totalPrize += rank.prizeMoney
        }

        return MatchResult(
            rankCounts = rankCounts,
            totalPrize = totalPrize,
            purchaseAmount = lottoTickets.size * Rule.LOTTO_PRICE
        )
    }

}