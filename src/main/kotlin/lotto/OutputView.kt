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
}