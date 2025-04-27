package lotto.domain


import camp.nextstep.edu.missionutils.Randoms
import lotto.Lotto
import lotto.view.InputView
import lotto.view.OutputView

object TicketMachine {

    fun buy(): PlayerData {
        val moneySpent = InputView.getPayment()
        val ticketCount = moneySpent / lotto.TICKET_PRICE
        val lottoTickets: List<Lotto> = List(ticketCount) { createdTicket() }
        OutputView.showPurchase(lottoTickets.map{it.getNumbers()})
        return PlayerData(moneySpent, lottoTickets)
    }

    private fun createdTicket(): Lotto {
        val numbers = Randoms.pickUniqueNumbersInRange(lotto.MIN_RANGE, lotto.MAX_RANGE, lotto.TICKET_LEN).sorted()
        return Lotto(numbers)
    }
}
