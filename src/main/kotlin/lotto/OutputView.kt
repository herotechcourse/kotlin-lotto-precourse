package lotto

class OutputView() {
    fun printPurchasedTickets(paidNumber: Int, tickets: List<Lotto>) {
        println("You have purchased $paidNumber tickets.")
        tickets.forEach { ticket ->
            println("${ticket.numbers}")
        }
    }

    fun printResults(winningResults: List<TicketResults>) {
        var countOne = 0
        var countTwo = 0
        var countThree = 0
        var countFour = 0
        var countFive = 0
        winningResults.forEach { result ->
            when (result.prize) {
                Prize.FIRST -> countOne++
                Prize.SECOND -> countTwo++
                Prize.THIRD -> countThree++
                Prize.FOURTH -> countFour++
                Prize.FIFTH -> countFive++
                Prize.NO_PRIZE -> print("You have no lotto matches this time. Try again.")
            }
        }

        println(
            "3 Matches (5,000 KRW) - ${countFive} ticket\n" +
                    "4 Matches (50,000 KRW) - ${countFour} tickets\n" +
                    "5 Matches (1,500,000 KRW) - ${countThree} tickets\n" +
                    "5 Matches + Bonus Ball (30,000,000 KRW) - ${countTwo}  tickets\n" +
                    "6 Matches (2,000,000,000 KRW) - ${countOne}  tickets\n"
        )
    }
}
