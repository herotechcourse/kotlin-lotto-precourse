package lotto.domain

import lotto.Lotto
import lotto.util.LottoNumberGenerator

class LottoMachine(
    private val numberGenerator: LottoNumberGenerator,
) {
    fun buyTickets(amount: Int): List<Lotto> {
        val ticketCnt = amount / 1000
        return (1..ticketCnt).map { Lotto(numberGenerator.generate())}
    }

    fun calculateResults(purchasedLottos: List<Lotto>, winningLotto: WinningLotto): LottoResults {
        return LottoResults(purchasedLottos, winningLotto)
    }
}