package lotto

class OutputView {
    fun promptPurchase (){
        print("Please enter the purchase amount : ")
    }

    fun ticketAmount(count: Int) {
        println("\nYou have purchased $count tickets.")
    }

    fun tickets(tickets: List<Lotto>){
        tickets.forEach { ticket ->
            println(ticket.getNumbers())
        }
    }

    fun promptWinningNumbers (){
        print("\nPlease enter last week's winning numbers (comma-separated) : ")
    }

    fun promptBonusNumber (){
        print("\nPlease enter the bonus number : ")
    }

    fun error(message: String)  {
        println("[ERROR] $message")
    }

    fun displayWinningStats(results: Map<PrizeRanks, Int>, profitRate: Double) {
        println("\nWinning Statistics")
        println("------------------")
        PrizeRanks.values()
            .filter { it != PrizeRanks.NONE }
            .forEach { tier ->
                println(formatTierResult(tier, results.getOrDefault(tier, 0)))
            }
        println("Total return rate is ${"%.1f".format(profitRate).replace(',', '.')}%.")
    }

    private fun formatTierResult(tier: PrizeRanks, count: Int): String {
        return "${tier.description} (${"%,d".format(tier.prizeMoney).replace('\u202F', ',')} KRW) – $count tickets"
    }

}