package lotto.domain

import  lotto.Lotto
import  lotto.support.*
import  camp.nextstep.edu.missionutils.Randoms

class LottoMachine (private val purchaseAmount: Int){
    val tickets: List<Lotto>

    init {
        require(purchaseAmount >= TICKET_PRICE) { Message.ERROR_AMOUNT_TOO_SMALL }
        require(purchaseAmount % TICKET_PRICE == 0) { Message.ERROR_AMOUNT_NOT_DIVISIBLE }
        tickets = generateTickets()
    }

    private fun generateTickets(): List<Lotto> {
        val ticketCount = purchaseAmount / TICKET_PRICE
        return List(ticketCount) {
            Lotto(Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER,
                MAX_LOTTO_NUMBER, TICKET_NUMBERS_COUNT))
        }
    }
}