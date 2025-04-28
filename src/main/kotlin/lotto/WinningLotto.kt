package lotto

class WinningLotto(private val winningNumbers: List<Int>, private val bonusNumber: Int) {
    init {
        require(winningNumbers.size == 6) { "[ERROR] Winning numbers must consist of 6 numbers." }
        require(winningNumbers.all { it in 1..45 }) { "[ERROR] Winning numbers must be between 1 and 45." }
        require(winningNumbers.distinct().size == 6) { "[ERROR] Winning numbers must be unique." }
        require(bonusNumber in 1..45) { "[ERROR] Bonus number must be between 1 and 45." }
        require(!winningNumbers.contains(bonusNumber)) { "[ERROR] Bonus number cannot be one of the winning numbers." }
    }

    fun compare(lottoTicket: LottoTicket): Prize {
        val matchCount = lottoTicket.match(winningNumbers)
        val hasBonus = lottoTicket.hasBonus(bonusNumber)
        return Prize.getPrize(matchCount, hasBonus)
    }
}