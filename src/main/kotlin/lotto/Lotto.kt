package lotto

import lotto.InputValidation.winning_numbers_size

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] Lotto must contain exactly 6 numbers." }
        require(numbers.distinct().size == 6 ){"[ERROR] Lotto numbers must be unique."}
        require(numbers.all { it in 1..45 }){"[ERROR] Lotto numbers must be in range of 1 to 45."}

    }
    fun CalculateNumberOfTickets(amount : Int) : Int{
        return (amount/1000)

    }
    fun GenerateLottoTickets(numberOfTickets : Int) : List<List<Int>> {
        val tickets = List(numberOfTickets) {
            (1..45).shuffled().take(6).sorted()
        }
       return tickets
    }
    fun PrintLottoTickets(tickets : List<List<Int>>,numberOfTickets: Int){
        println("Number of tickets issued and their numbers (sorted in ascending order):")
        println("You have purchased $numberOfTickets tickets")
        for (ticket in tickets){println(ticket)}
    }
}
