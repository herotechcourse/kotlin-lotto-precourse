package lotto

class OutputView {
    fun printTickets(tickets: List<Lotto>) {
        println("\nYou have purchased ${tickets.size} tickets.")
        tickets.forEach { ticket ->
            println(ticket.getNumbers())
        }
    }
    
    fun printResults(statistics: Map<LottoResult, Int>, returnRate: Double) {
        println("\nWinning Statistics")
        println("---")
        
        LottoResult.values().filterNot { it == LottoResult.NONE }.forEach { result ->
            val count = statistics.getOrDefault(result, 0)
            println("${result.description} (${formatPrize(result.prize)} KRW) – ${count} tickets")
        }
        
        println("Total return rate is ${String.format("%.1f", returnRate)}%.")
    }
    
    fun printError(message: String) {
        println(message)
    }
    
    private fun formatPrize(prize: Long): String {
        return prize.toString().replace(Regex("(\\d)(?=(\\d{3})+$)"), "$1,")
    }
}