package lotto.utils

import camp.nextstep.edu.missionutils.Randoms
import lotto.Lotto

interface LottoTicketGenerator {
    fun generateNumberOfTickets(purchaseAmount: Int): Int
    fun generateTickets(numberOfTickets: Int): List<Lotto>
    fun generateRandomNumbersInRange(): List<Int>
}

class LottoTicketGeneratorImpl : LottoTicketGenerator {
    override fun generateNumberOfTickets(purchaseAmount: Int): Int {
        val numberOfTickets = purchaseAmount / 1000
        return numberOfTickets
    }

    override fun generateTickets(numberOfTickets: Int): List<Lotto> {
        val tickets = mutableListOf<Lotto>()
        repeat(numberOfTickets){
            val singleTicket = generateRandomNumbersInRange().sorted()
            val lottoTicket = Lotto(singleTicket)
            tickets.add(lottoTicket)
        }
        return tickets
    }

    override fun generateRandomNumbersInRange(): List<Int> {
        val listOfNumbers = Randoms.pickUniqueNumbersInRange(1,45,6)
        return listOfNumbers
    }
}