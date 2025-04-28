package lotto

object OutputView {

    fun printPurchasedTickets(lottoTickets: LottoTickets) {
        println("You have purchased ${lottoTickets.tickets.size} tickets.")
        lottoTickets.tickets.forEach { ticket ->
            println(ticket.numbers)
        }
    }

    fun printResult(result: LottoResult) {
        println("\nWinning Statistics")
        println("---")
        println("3 Matches (5,000 KRW) – ${result.match3} tickets")
        println("4 Matches (50,000 KRW) – ${result.match4} tickets")
        println("5 Matches (1,500,000 KRW) – ${result.match5} tickets")
        println("5 Matches + Bonus Ball (30,000,000 KRW) – ${result.match5WithBonus} tickets")
        println("6 Matches (2,000,000,000 KRW) – ${result.match6} tickets")
        println("Total return rate is ${"%.1f".format(result.returnRate)}%.")
    }
}
