package lotto.domain

import camp.nextstep.edu.missionutils.Randoms

class LottoTickets(private val tickets: List<Lotto>) {

    companion object {
        fun generate(money: Money): LottoTickets {
            val ticketList = List(money.getNumberOfTickets()) {
                Lotto(
                    Randoms.pickUniqueNumbersInRange(1, 45, 6)
                )
            }
            return LottoTickets(ticketList)
        }
    }

    fun getTickets(): List<Lotto> {
        return tickets
    }

}