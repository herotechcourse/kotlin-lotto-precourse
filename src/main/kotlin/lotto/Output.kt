package lotto

class OutputView {
    fun promptPurchase (){
        println("Please enter the purchase amount :")
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
        println("\nPlease enter last week's winning numbers (comma-separated) :")
    }

    fun promptBonusNumber (){
        println("\nPlease enter the bonus number :")
    }

    fun error(message: String)  {
        println("[ERROR] $message")
    }

    fun displayWinningStats(results: Map<PrizeRanks, Int>) {
        println("\nWinning Statistics")
        println("------------------")
        PrizeRanks.values()
            .filter { it != PrizeRanks.NONE }
            .forEach { tier ->
                println(formatTierResult(tier, results.getOrDefault(tier, 0)))
            }
    }

    private fun formatTierResult(tier: PrizeRanks, count: Int): String {
        return "${tier.description} (${"%,d".format(tier.prizeMoney)} KRW) - $count tickets"
    }

}