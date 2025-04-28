package lotto


class OutputView {

    val lotteryMachine = LotteryMachine()

    fun printPurchasedTickets(tickets: List<Lotto>) {
        println("You have purchased ${tickets.size} tickets.")
        tickets.forEach { println(it.getNumbers()) }
    }

    fun printResult(tickets: List<Lotto>, winningNumbers: List<Int>, bonusNumber: Int){
        val prizeCounts = lotteryMachine.calculateWinnings(tickets, winningNumbers, bonusNumber)
        println("Winning Statistics")
        println("---")
        prizeCounts.forEach { (prize, count) ->
         val prizeAmount = when (prize) {
             "6 Matches" -> "2,000,000,000 KRW"
             "5 Matches + Bonus Ball" -> "30,000,000 KRW"
             "5 Matches" -> "1,500,000 KRW"
             "4 Matches" -> "50,000 KRW"
             "3 Matches" -> "5,000 KRW"
             else -> ""
         }
         println("$prize ($prizeAmount) – $count tickets")
     }
        val returnRate = lotteryMachine.calculateReturnRate(prizeCounts, tickets.size)
        println("Total return rate is %.1f%%.".format(returnRate))
 }
}