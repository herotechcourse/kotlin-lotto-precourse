package lotto

object OutputView {
    fun printTickets(tickets: List<List<Int>>, ticketNumber: Int) {
        println()
        println("You have purchased $ticketNumber tickets.")
        for (ticket in tickets) {
            if (ticket.isNotEmpty())
                println(ticket)
        }
        println()
    }

    fun printPrizeStatics(prizeRankList: MutableList<Prize>, prize: Int, purchaseAmount: Int) {
        var rate: Double = prize.toDouble().div(purchaseAmount.toDouble()) * 100

        println()
        println("Winning Statistics")
        println("---")
        println("3 Matches (5,000 KRW) – ${prizeRankList.count { it == Prize.FifthPrize }} tickets")
        println("4 Matches (50,000 KRW) – ${prizeRankList.count { it == Prize.FourthPrize }} tickets")
        println("5 Matches (1,500,000 KRW) – ${prizeRankList.count { it == Prize.ThirdPrize }} tickets")
        println("5 Matches + Bonus Ball (30,000,000 KRW) – ${prizeRankList.count { it == Prize.SecondPrize }} tickets")
        println("6 Matches (2,000,000,000 KRW) – ${prizeRankList.count { it == Prize.FirstPrize }} tickets")
        println("Total return rate is %.1f%%.".format(rate))
    }

}