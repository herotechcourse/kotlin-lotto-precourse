package lotto

class OutputView {

    fun printHeader(message: String)
    {
        println()
        println(message)
    }
    fun printListOfTickets(items: List<Lotto>)
    {
        for (item in items)
        {
            println("[${item.numberToString()}]")
        }
    }
    fun printResults(counts: List<Int>)
    {
        println("3 Matches (5,000 KRW) – ${counts[0]} tickets")
        println("4 Matches (50,000 KRW) – ${counts[1]} tickets")
        println("5 Matches (1,500,000 KRW) – ${counts[2]} tickets")
        println("5 Matches + Bonus Ball (30,000,000 KRW) – ${counts[3]} tickets")
        println("6 Matches (2,000,000,000 KRW) – ${counts[4]} tickets")
    }

    fun printMessage(message: String)
    {
        println(message)
    }
}