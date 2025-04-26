package lotto.model

object MATCH {
    var SIX = 0
    var FIVE_AND_BONUS = 0
    var FIVE = 0
    var FOUR = 0
    var THREE = 0
}

const val FIRST_PRIZE = 2000000000
const val SECOND_PRIZE = 30000000
const val THIRD_PRIZE = 1500000
const val FOURTH_PRIZE = 50000
const val FIFTH_PRIZE = 5000

object MatchCalculator {
    fun run(lottoNumber: List<List<Int>>, winningNumbers: List<String>, bonusNumber: String): Int {
        val winningNumbers = winningNumbers.map { it -> it.toInt() }
        val bonusNumber = bonusNumber.toInt()

        matchOneToSixCount(lottoNumber, winningNumbers)
        matchFiveAndBonusNumberCount(lottoNumber, winningNumbers, bonusNumber)

        return calculateWinningAmount()
    }

    private fun matchOneToSixCount(lottoNumber: List<List<Int>>, winningNumbers: List<Int>) {
        for (lottoNumberOneLine in lottoNumber) {
            val intersectionNumber = lottoNumberOneLine.intersect(winningNumbers)
            if (intersectionNumber.size == 3) MATCH.THREE++
            if (intersectionNumber.size == 4) MATCH.FOUR++
            if (intersectionNumber.size == 6) MATCH.SIX++
        }
    }

    private fun matchFiveAndBonusNumberCount(
        lottoNumbers: List<List<Int>>,
        winningNumbers: List<Int>,
        bonusNumber: Int,
    ) {
        lottoNumbers.forEach { lottoTicket ->
            checkFiveMatchWithBonus(lottoTicket, winningNumbers, bonusNumber)
        }
    }

    private fun checkFiveMatchWithBonus(
        lottoTicket: List<Int>,
        winningNumbers: List<Int>,
        bonusNumber: Int,
    ) {
        val intersection = lottoTicket.intersect(winningNumbers)

        if (intersection.size != 5) return

        if (bonusNumber in lottoTicket) {
            MATCH.FIVE_AND_BONUS++
            return
        }

        MATCH.FIVE++
    }

    private fun calculateWinningAmount(): Int =
        (MATCH.SIX * FIRST_PRIZE) +
        (MATCH.FIVE_AND_BONUS * SECOND_PRIZE) +
        (MATCH.FIVE * THIRD_PRIZE) +
        (MATCH.FOUR * FOURTH_PRIZE) +
        (MATCH.THREE * FIFTH_PRIZE)
}
