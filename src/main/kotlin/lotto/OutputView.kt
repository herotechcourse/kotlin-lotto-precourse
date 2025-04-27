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
//    fun printListOfItems(items: List<Int>)
//    {
//        for (item in items)
//        {
//            println(item.toString())
//        }
//    }
}