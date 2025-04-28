package lotto

class PrintingFunctionalityClass {

    fun printLottoTickets (lottoTickets: List<Lotto>)
    {
        println("\nYou have purchased " + lottoTickets.size + " tickets.")
        for (ticket in lottoTickets)
            println(ticket.numbersGetter())
    }

    fun printFinalResults (statistics: MutableList<Double>)
    {
        println("\nWinning Statistics\n---")
        println("3 Matches (5,000 KRW) – " + statistics[0].toInt() + " tickets")
        println("4 Matches (50,000 KRW) – " + statistics[1].toInt() + " tickets")
        println("5 Matches (1,500,000 KRW) – " + statistics[2].toInt() + " tickets")
        println("5 Matches + Bonus Ball (30,000,000 KRW) – " + statistics[3].toInt() + " tickets")
        println("6 Matches (2,000,000,000 KRW) – " + statistics[4].toInt() + " tickets")
        println("Total return rate is " + String.format("%.1f", statistics[5]).toDouble() + "%.")
    }
}
