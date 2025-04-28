package lotto.utils

import lotto.Lotto
import lotto.Lottos
import lotto.WinningNumbers

object ResultCalculator {
    fun calculateMatches(lottos: Lottos, winningNumbers: WinningNumbers): Map<String, Int> {
        val tickets = lottos.getTickets()
        val winningNumbersList = winningNumbers.getWinningNumbers()
        val bonusNumber = winningNumbers.getBonusNumber()
        val result = mutableMapOf<String, Int>("3" to 0, "4" to 0, "5" to 0, "5+bonus" to 0, "6" to 0)

        for (ticket in tickets) {
            val matchCount = matchCount(ticket, winningNumbersList)
            if (matchCount == "5" && ticket.getNumbers().contains(bonusNumber)) {
                result["5+bonus"] = result["5+bonus"]!! + 1
            } else if (matchCount.toInt() in 3..6) {
                result[matchCount] = result[matchCount]!! + 1
            } else continue
        }
        return result
    }

    fun matchCount(lotto: Lotto, winningNumbersList: List<Int>): String {
        val lottoNumbers = lotto.getNumbers()
        var total = 0
        for (number in lottoNumbers) {
            if (winningNumbersList.contains(number)) {
                total++
            }
        }
        return total.toString()
    }
}