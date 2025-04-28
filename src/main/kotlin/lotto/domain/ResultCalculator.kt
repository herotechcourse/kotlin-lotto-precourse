package lotto.domain

object ResultCalculator {
    fun calculateMatchedLottoCount(lottos: Lottos, winningNumbers: WinningNumbers, bonusNumber: BonusNumber): Map<LottoRank, Int> {
        return lottos.tickets
            .map { it.match(winningNumbers, bonusNumber) }
            .groupingBy { it }
            .eachCount()
    }
}