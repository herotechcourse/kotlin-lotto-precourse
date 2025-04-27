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

    //6. Calculate total return rate and display as output
    fun calculateReturnRate(resultCount: MutableMap<LottoEnum, Int>, noOfTickets: Int) {
        var totalWinningAmount = 0
        var amount = 0
        for ((key, count) in resultCount) {
            val prizeAmount = key.Amount
            amount = prizeAmount * count
            totalWinningAmount += amount
        }

        val actualAmount = noOfTickets * 1000
        val returnRate = totalWinningAmount.toDouble() / actualAmount * 100
        println("Total return rate is %.1f%%.".format(returnRate))
    }

    fun displayTickets(tickets: MutableList<MutableList<Int>>) {
        tickets.forEach { ticket ->
            println(ticket)

        }
    }
}