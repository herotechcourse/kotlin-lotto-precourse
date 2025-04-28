package lotto

class OutputHandler {
    fun printPurchasedLottos(lottos: List<Lotto>) {
        val lottoCount = lottos.size
        println("\nYou have purchased $lottoCount tickets.")
        lottos.forEach { println(it) }
        println()
    }

     fun printWinningStatistics(winningStatistics: Map<Rank, Int>, totalAmount: Int) {
        println("Winning Statistics")
        println("---")
        
        Rank.values().reversed().forEach { rank ->
            val count = winningStatistics.getOrDefault(rank, 0)
            println("${rank.description} – $count tickets")
        }
        
        val totalWinningAmount = calculateTotalWinnings(winningStatistics)
        val returnRate = (totalWinningAmount.toDouble() / totalAmount) * 100
        
        println("Total return rate is ${String.format("%.1f", returnRate)}%.")
    }
    
    private fun calculateTotalWinnings(winningStatistics: Map<Rank, Int>): Int {
        return winningStatistics.entries.sumOf { (rank, count) -> rank.prize * count }
    }
}