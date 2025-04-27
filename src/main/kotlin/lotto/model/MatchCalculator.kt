package lotto.model

import lotto.Lotto

object MATCH{
    var SIX = 0
    var FIVE_AND_BONUS = 0
    var FIVE = 0
    var FOUR = 0
    var THREE = 0
}

object MatchCalculator {
    fun run(totalLottoTicket: List<Lotto>, winningNumbers: List<String>, bonusNumber: String): Int {
        val winningNumbers = winningNumbers.map { it -> it.toInt() }
        val bonusNumber = bonusNumber.toInt()

        matchOneToSixCount(totalLottoTicket, winningNumbers)
        matchFiveAndBonusNumberCount(totalLottoTicket, winningNumbers, bonusNumber)

        return calculateWinningAmount()
    }

    private fun matchOneToSixCount(totalLottoTicket: List<Lotto>, winningNumbers: List<Int>) {
        for (lottoTicket in totalLottoTicket) {
            val intersectionNumber = lottoTicket.getNumbers().intersect(winningNumbers)
            if (intersectionNumber.size == 3) MATCH.THREE++
            if (intersectionNumber.size == 4) MATCH.FOUR++
            if (intersectionNumber.size == 6) MATCH.SIX++
        }
    }

    private fun matchFiveAndBonusNumberCount(
        totalLottoTickets: List<Lotto>,
        winningNumbers: List<Int>,
        bonusNumber: Int,
    ) {
        totalLottoTickets.forEach { lottoTicket ->
            checkFiveMatchWithBonus(lottoTicket, winningNumbers, bonusNumber)
        }
    }

    private fun checkFiveMatchWithBonus(
        lottoTicket: Lotto,
        winningNumbers: List<Int>,
        bonusNumber: Int,
    ) {
        val intersection = lottoTicket.getNumbers().intersect(winningNumbers)

        if (intersection.size != 5) return

        if (bonusNumber in lottoTicket.getNumbers()) {
            MATCH.FIVE_AND_BONUS++
            return
        }

        MATCH.FIVE++
    }

    private fun calculateWinningAmount(): Int =
        (MATCH.SIX * LottoRank.FIRST.prize) +
        (MATCH.FIVE_AND_BONUS * LottoRank.SECOND.prize) +
        (MATCH.FIVE * LottoRank.THIRD.prize) +
        (MATCH.FOUR * LottoRank.FOURTH.prize) +
        (MATCH.THREE * LottoRank.FIFTH.prize)
}
