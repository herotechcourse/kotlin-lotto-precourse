package lotto

class OutputView {
    fun printTickets(tickets: List<Lotto>) {
        println("You have purchased ${tickets.size} tickets.")
        for (ticket in tickets) {
            println(ticket)
        }
        println()
    }

    fun printResult(result: PrizeResult) {
        println("Winning Statistics\n---")
        for ((rank, count) in result.count.entries.reversed()) {
            if (rank.matchCount == 0) continue
            val bonusText = if (rank.bonusRequired) " + Bonus Ball" else ""
            val prizeText = rank.prizeMoney.formatWithComma()
            println("${rank.matchCount} Matches${bonusText} ($prizeText KRW) – $count tickets")
        }
        val rate = (result.returnRate * 100).roundToDecimalPlaces(1).formatWithComma()
        println("Total return rate is ${rate}%.")
    }
}