package lotto.domain

import camp.nextstep.edu.missionutils.Randoms

object LottoGenerator {

    private const val TICKET_PRICE = 1000

    fun generateFromMoney(money: Int): LottoTickets {
        require(money >= TICKET_PRICE) { "[ERROR] At least one ticket must be purchased (₩1,000 minimum)." }

        val count = money / TICKET_PRICE
        val tickets = List(count) {
            Lotto.of(Randoms.pickUniqueNumbersInRange(1, 45, 6))
        }
        return LottoTickets(tickets)
    }
}