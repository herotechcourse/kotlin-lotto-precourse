package lotto.model

object MATCH {
    var THREE = 0
    var FOUR = 0
    var FIVE = 0
    var FIVE_AND_BONUS = 0
    var SIX = 0
}

object MatchCalculator {

    fun run(lottoNumber: List<List<Int>>, winningNumbers: List<String>, bonusNumber: String) {
        matchOneToSixCount(lottoNumber, winningNumbers)
        mathFiveAndBonusNumberCount(lottoNumber, winningNumbers, bonusNumber)
    }

    private fun matchOneToSixCount(lottoNumber: List<List<Int>>, winningNumbers: List<String>) {
        for (lottoNumberOneLine in lottoNumber) {
            val winningNumbers = winningNumbers.map { it -> it.toInt() }
            val intersectionNumber = lottoNumberOneLine.intersect(winningNumbers)
            if (intersectionNumber.size == 3) MATCH.THREE++
            if (intersectionNumber.size == 4) MATCH.FOUR++
            if (intersectionNumber.size == 6) MATCH.SIX++
        }
    }

    private fun mathFiveAndBonusNumberCount(
        lottoNumber: List<List<Int>>, winningNumbers: List<String>, bonusNumber: String
    ) {
        for (lottoNumberOneLine in lottoNumber) {
            val winningNumbers = winningNumbers.map { it -> it.toInt() }
            val intersectionNumber = lottoNumberOneLine.intersect(winningNumbers)

            if (intersectionNumber.size == 5) {
                    if (lottoNumberOneLine.contains(bonusNumber.toInt())) {
                        MATCH.FIVE_AND_BONUS++
                    } else {
                        MATCH.FIVE++
                    }
                }
        }
    }
}