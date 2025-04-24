package lotto.service

import lotto.domain.LottoTickets
import lotto.domain.Rank
import lotto.domain.WinningNumbers

/**
 * Service class responsible for evaluating Lotto tickets against the winning numbers.
 *
 * This class compares each ticket to the provided [WinningNumbers] instance,
 * determines the corresponding [Rank] based on match count and bonus number,
 * and tallies how many tickets fall into each prize category.
 *
 * The result is returned as a map of [Rank] to the number of winning tickets,
 * sorted by prize amount in descending order.
 *
 * Usage:
 * ```
 * val game = LottoGame(tickets, winningNumbers)
 * val result: Map<Rank, Int> = game.evaluate()
 * ```
 */
class LottoGame(
    private val tickets: LottoTickets,
    private val winningNumbers: WinningNumbers
) {
    fun evaluate(): Map<Rank, Int> {
        val results = mutableMapOf<Rank, Int>()

        tickets.getAll().forEach { ticket ->
            val matchCount = winningNumbers.countMatches(ticket)
            val bonusMatch = winningNumbers.isBonusMatch(ticket)
            val rank = Rank.from(matchCount, bonusMatch)

            rank?.let {
                results[it] = results.getOrDefault(it, 0) + 1
            }
        }

        return results.toSortedMap(compareByDescending { it.prize })
    }
}