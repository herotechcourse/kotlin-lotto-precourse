package lotto

import camp.nextstep.edu.missionutils.Randoms

class TicketCreator
{

    private fun produceSingleTicket() : Lotto {
        var initiatorList = Randoms.pickUniqueNumbersInRange(1, 45, 6)
        val lottoTicket = Lotto(initiatorList)
        return lottoTicket
    }

    fun createTickets(moneySpent : Int) : List<Lotto> {
        val ticketsList = mutableListOf<Lotto>()
        for (i in 1..moneySpent / 1000) {
            ticketsList.add(produceSingleTicket())
        }
        return ticketsList
    }
}