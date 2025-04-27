package lotto.service

import lotto.Lotto
import lotto.domain.*
import lotto.utils.Validator

class LottoService {
    fun purchaseTickets(amount: Int): List<Lotto> {
        Validator.validateAmount(amount)
        return LottoGenerator.generateTickets(amount)
    }

    fun calculateResults(tickets: List<Lotto>, winningLotto: WinningLotto): LottoResult {
        val lottoResult = LottoResult()
        tickets.forEach { ticket ->
            val (matchCount, bonusMatch) = winningLotto.match(ticket)
            val rank = Rank.findByMatch(matchCount, bonusMatch)
            if (rank != null) {
                lottoResult.addResult(rank)
            }
        }
        return lottoResult
    }

    fun calculateProfitRate(money: Int, lottoResult: LottoResult): Double {
        return lottoResult.calculateProfit(money)
    }
}
