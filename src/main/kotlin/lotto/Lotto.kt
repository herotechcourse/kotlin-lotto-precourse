package lotto

import camp.nextstep.edu.missionutils.Randoms

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] Lotto must contain exactly 6 numbers." }
        require(numbers.distinct().size == 6) { "[ERROR] Lotto numbers must be unique." }
        require(numbers.all { it in 1..45 }) { "[ERROR] Lotto numbers must be in range of 1 to 45." }
    }

    //Calculate the number of tickets that can be issued
    fun CalculateNumberOfTickets(amount: Int): Int {
        return (amount / 1000)
    }

    //Generate the lotto tickets
    fun GenerateLottoTickets(numberOfTickets: Int): List<List<Int>> {
        val tickets = List(numberOfTickets) {
            Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted()
        }
        return tickets
    }
}
