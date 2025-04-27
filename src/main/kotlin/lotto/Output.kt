package lotto

class Output {

    //5. Display the winning statistics with the number of matches in each ticket
    fun displayWinningStatistics(resultCount: MutableMap<LottoEnum, Int>) {
        println("Winning Statistics")
        println("---")

        LottoEnum.entries.forEach { result ->
            println("${result.Output} – ${resultCount.getValue(result)} tickets")
        }
    }

    fun displayTickets(tickets: MutableList<MutableList<Int>>) {
        tickets.forEach { ticket ->
            println(ticket)

        }
    }
}