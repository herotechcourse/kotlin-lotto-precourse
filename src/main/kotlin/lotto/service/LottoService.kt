package lotto.service

import lotto.enums.LottoRank
import lotto.model.LottoResult
import lotto.model.LottoStore
import lotto.model.LottoStore.Companion.LOTTO_PRICE
import lotto.model.LottoTicket
import lotto.model.WinningLotto

class LottoService {
    fun createLottoTicket(purchaseMoney: String): LottoTicket {
        return LottoStore.makeLottoTicket(purchaseMoney)
    }

    fun createWinningLotto(winningNumber: String): WinningLotto {
        return WinningLotto.create(winningNumber)
    }

    fun addBonusNumber(winningLotto: WinningLotto, bonusNumber: String) {
        winningLotto.addBonusNumber(bonusNumber)
    }

    fun compareLotto(lottoTicket: LottoTicket, winningLotto: WinningLotto): LottoResult {
        val lottoResult: LottoResult = LottoResult()
        lottoResult.compare(lottoTicket, winningLotto)
        return lottoResult
    }

    fun calculateEarnings(rankResults: Map<LottoRank, Int>, lottoTicket: LottoTicket): Double {
        val purchaseMoney: Int = lottoTicket.getLottosCount() * LOTTO_PRICE
        var totalEarnings = 0L
        for (rank in rankResults.keys) {
            val count = rankResults[rank]!!
            totalEarnings += (rank.prize * count).toLong()
        }
        val earningsRate = totalEarnings.toDouble() / purchaseMoney * 100
        return Math.round(earningsRate * 10) / 10.0
    }
}
