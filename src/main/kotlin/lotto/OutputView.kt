package lotto

object OutputView {
    fun printTickets(tickets: List<LottoTicket>) {
        println("You have purchased ${tickets.size} tickets.")
        tickets.forEach { println(it.lotto.getNumbers()) }
    }

    fun printResult(result: LottoResult) {
        println("Winning Statistics\n---")
        Rank.values().sortedBy { it.prize }.reversed().forEach { rank ->
            println("${rank.description} – ${result.rankCount(rank)} tickets")
        }
        println("Total return rate is ${result.profitRate()}%.")
    }
}
