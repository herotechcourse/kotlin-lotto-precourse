package lotto

class ResultCalculator {
    fun calculateResults(tickets: List<Lotto>, winningNumbers: WinningNumbers): Map<Rank, Int> {
        val results = mutableMapOf<Rank, Int>()

        tickets.forEach { ticket ->
            val matchCount = ticket.getNumbers().count { it in winningNumbers.getWinningNumbers() }
            val bonusMatch = ticket.getNumbers().contains(winningNumbers.getBonusNumber())

            val rank = Rank.findRank(matchCount, bonusMatch)
            if (rank != null) {
                results[rank] = results.getOrDefault(rank, 0) + 1
            }
        }
        return results
    }

    fun calculateProfitRate(results: Map<Rank, Int>, purchaseAmount: Int): Double {
        val totalWinning = results.entries.sumOf { (rank, count) ->
            rank.prize.toLong() * count
        }
        return totalWinning.toDouble() / purchaseAmount * 100
    }
}
