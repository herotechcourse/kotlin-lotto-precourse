package lotto.domain

import camp.nextstep.edu.missionutils.Randoms

class LottoTickets(private val tickets: List<LottoTicket>) {

    companion object {
        fun generate(money: Money): LottoTickets {
            val ticketList = List(money.getNumberOfTickets()) {
                LottoTicket(
                    Randoms.pickUniqueNumbersInRange(1, 45, 6)
                )
            }
            return LottoTickets(ticketList)
        }
    }

    fun getTickets(): List<LottoTicket> {
        return tickets
    }

}