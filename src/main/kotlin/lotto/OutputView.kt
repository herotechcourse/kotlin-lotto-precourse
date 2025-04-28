package lotto

object OutputView {
    fun printTickets(lottoTickets: List<Lotto>) {
        if (lottoTickets.isEmpty()) {
            throw IllegalStateException("[ERROR] No tickets have been purchased yet.]")
        }
        println("\nYou have purchased ${lottoTickets.size} tickets.")
        for (lotto in lottoTickets) {
            println(lotto.getNumbers().sorted().joinToString(prefix="[", postfix="]", separator = ", "))
        }
    }

    fun printResultStatistics(result: Map<ResultRank, Int>) {
        println("\nWinning Statistics")
        println("---")
        ResultRank.entries
            .filter { it != ResultRank.NO_WIN }
            .sortedBy { it.matchCount }
            .forEach { rank ->
                val count = result.getOrDefault(rank, 0)
                println("${rank.matchCount} Matches${rank.bonusText} (${formatMoney(rank.prizeMoney)} KRW) – $count tickets")
            }
    }

    private fun formatMoney(amount: Int): String {
        return amount.toString().replace(Regex("(?<=\\d)(?=(\\d{3})+(?!\\d))"), ",")
    }

    fun printProfitRate(profitRate: Double) {
        val formattedProfitRate = String.format("%.1f", profitRate)
        println("Total return rate is $formattedProfitRate%.")
    }
}
