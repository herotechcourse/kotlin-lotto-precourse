package lotto.model

import lotto.Lotto

object Match{
    var sixCount = 0
    var fiveAndBonusCount = 0
    var fiveCount = 0
    var fourCount = 0
    var threeCount = 0
}

object MatchCalculator {
    fun calculate(totalLottoTicket: List<Lotto>, winningNumbers: List<String>, bonusNumber: String): Int {
        val winningNumbers = winningNumbers.map { it -> it.toInt() }
        val bonusNumber = bonusNumber.toInt()

        countMatchesThreeFourSix(totalLottoTicket, winningNumbers)
        countTotalFiveMatchesWithBonus(totalLottoTicket, winningNumbers, bonusNumber)

        return calculateWinningAmount()
    }
    
    private fun countMatchesThreeFourSix(totalLottoTicket: List<Lotto>, winningNumbers: List<Int>) {
        for (lottoTicket in totalLottoTicket) {
            val intersectionNumber = lottoTicket.getNumbers().intersect(winningNumbers)
            if (intersectionNumber.size == 3) Match.threeCount++
            if (intersectionNumber.size == 4) Match.fourCount++
            if (intersectionNumber.size == 6) Match.sixCount++
        }
    }

    private fun countTotalFiveMatchesWithBonus(
        totalLottoTickets: List<Lotto>,
        winningNumbers: List<Int>,
        bonusNumber: Int,
    ) {
        totalLottoTickets.forEach { lottoTicket ->
            countFiveMatchWithBonus(lottoTicket, winningNumbers, bonusNumber)
        }
    }

    private fun countFiveMatchWithBonus(
        lottoTicket: Lotto,
        winningNumbers: List<Int>,
        bonusNumber: Int,
    ) {
        val intersection = lottoTicket.getNumbers().intersect(winningNumbers)

        if (intersection.size != 5) return

        if (bonusNumber in lottoTicket.getNumbers()) {
            Match.fiveAndBonusCount++
            return
        }
        Match.fiveCount++
    }

    private fun calculateWinningAmount(): Int =
        (Match.sixCount * LottoRank.FIRST.prize) +
        (Match.fiveAndBonusCount * LottoRank.SECOND.prize) +
        (Match.fiveCount * LottoRank.THIRD.prize) +
        (Match.fourCount * LottoRank.FOURTH.prize) +
        (Match.threeCount * LottoRank.FIFTH.prize)
}
