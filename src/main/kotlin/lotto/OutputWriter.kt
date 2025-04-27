package lotto

class OutputWriter(private val outputView: OutputView = OutputView()) {
    fun printTickets(lottoTickets: List<Lotto>) {
        val ticketList = lottoTickets.map { it.getNumbers() }
        outputView.showTickets(ticketList)
    }

    fun printWinningStatistics(statistics: Map<Rank, Int>) {
        outputView.showWinningStatistics(statistics)
    }

    fun printTotalReturnRate(statistics: Map<Rank, Int>, purchaseAmount: Int) {
        var totalPrizeMoney = calculateTotalPrizeMoney(statistics)
        val totalReturnRate = (totalPrizeMoney / purchaseAmount) * 100
        outputView.showTotalReturnRate(totalReturnRate)
    }

    private fun calculateTotalPrizeMoney(statistics: Map<Rank, Int>): Double {
        return statistics.entries.sumOf { (rank, count) -> rank.prizeMoney.toDouble() * count }
    }
}