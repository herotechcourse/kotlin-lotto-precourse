package lotto

data class WinningLotto(val winningNumbers: Lotto, val bonusNumber: Int) {
    init {
        require(!winningNumbers.contains(bonusNumber)) { "The bonus number must be different from the winning numbers." }
    }

    fun match(lottoTickets: List<Lotto>): List<LottoRank> {
        return lottoTickets.map { LottoRank.calculate(it, this) }
    }
}
