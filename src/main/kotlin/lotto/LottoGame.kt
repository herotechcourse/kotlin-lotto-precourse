package lotto

class LottoGame(
    private val playerTicket: List<Lotto>,
    private val winningTicket: Lotto,
    private val bonusNumber: Int
) {
    private val results: MutableMap<Rank, Int> = mutableMapOf()
    private var totalWinnings: Long = 0

    fun play() {
        totalWinnings = 0

        for (ticket in playerTicket) {
            val winningNumbers = winningTicket.getNumbers()
            val matchCount = ticket.countMatches(winningNumbers)
            val bonusCheck = ticket.hasNumber(bonusNumber)

            val rank = Rank.getRank(matchCount, bonusCheck)

            results[rank] = results.getOrDefault(rank, 0) + 1

            totalWinnings += rank.prizeAmount
        }
    }

    fun getResults() = results

    fun getTotalWinnings() = totalWinnings
}
