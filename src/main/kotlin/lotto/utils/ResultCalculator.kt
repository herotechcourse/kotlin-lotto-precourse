package lotto.utils

import lotto.Lotto
import lotto.Lottos
import lotto.WinningNumbers

object ResultCalculator {
    fun calculateMatches(lottos: Lottos, winningNumbers: WinningNumbers) : Map<String, Int> {
        val tickets = lottos.getTickets()
        val winningSet = winningNumbers.getWinningNumbers().toSet()
        val bonus = winningNumbers.getBonusNumber()
        val result = mutableMapOf<String, Int>()

        for (ticket in tickets) {
            val matchCount = ticket.getNumbers().count { it in winningSet }
            val key = if (matchCount == 5 && ticket.getNumbers().contains(bonus)) {
                "5+bonus"
            } else {
                matchCount.toString()
            }
            result[key] = result.getOrDefault(key, 0) + 1
        }

        return result

    }

    fun matchCount(lotto: Lotto, winningNumbers: WinningNumbers): String {
        val winningNumbersList = winningNumbers.getWinningNumbers()
        val total = lotto.getNumbers().count { it in winningNumbersList }
        return total.toString()
    }
}