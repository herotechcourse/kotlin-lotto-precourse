package lotto.service

import lotto.Lotto
import lotto.domain.LottoMachine
import lotto.domain.Rank
import lotto.domain.RankCalculator
import lotto.domain.WinningNumbers

class LottoService {
    private val lottoMachine = LottoMachine()

    fun purchaseLottos(amount: Int): List<Lotto> {
        return lottoMachine.buyLottos(amount)
    }

    fun calculateResults(lottos: List<Lotto>, winningNumbers: WinningNumbers): Map<Rank, Int> {
        return lottos
            .map { determineRank(it, winningNumbers) }
            .groupingBy { it }
            .eachCount()
    }

    private fun determineRank(lotto: Lotto, winningNumbers: WinningNumbers): Rank {
        return RankCalculator.calculate(lotto, winningNumbers)
    }
}