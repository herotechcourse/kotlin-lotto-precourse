package lotto

class Output {

    fun printIssuedTickets(count: Int, issuedTickets: List<List<Int>>) {
        println("You have purchased $count tickets.")
        issuedTickets.forEach {
            println(it)
        }
        println()
    }
}
