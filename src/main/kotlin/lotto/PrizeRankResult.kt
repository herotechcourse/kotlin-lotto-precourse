package lotto

class PrizeRankResult(val statistics: Map<PrizeRank, Int>) {

    fun calculateProfitRate(lottoTickets: List<Lotto>): Double {
        return (getTotalPrizeAmount() / getPurchasedAmount(lottoTickets)) * PERCENTAGE_MULTIPLIER
    }

    private fun getTotalPrizeAmount(): Double {
        return statistics.entries.sumOf { (rank, count) -> rank.prizeAmount * count }
            .toDouble()
    }

    private fun getPurchasedAmount(lottoTickets: List<Lotto>): Int {
        return lottoTickets.size * TICKET_PRICE
    }

    companion object {
        private const val TICKET_PRICE: Int = 1_000
        private const val PERCENTAGE_MULTIPLIER: Double = 100.0
    }
}
