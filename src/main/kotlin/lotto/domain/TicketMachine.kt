package lotto.domain


import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import lotto.Lotto
import lotto.MAX_RANGE
import lotto.MIN_RANGE
import lotto.TICKET_LEN
import lotto.view.InputView
import lotto.view.OutputView

object TicketMachine {

    fun buy(): List<List<Int>> {
        OutputView.requestUser("Please enter the amount of money you want to spend.")
        val amountRequested = InputView.getPayment(Console.readLine()) / lotto.TICKET_PRICE
        val ticketsPurchase: List<List<Int>> = List(amountRequested) { createdTicket().getNumbers() }
        OutputView.showPurchase(ticketsPurchase)
        return ticketsPurchase
    }

    private fun createdTicket(): Lotto {
        val numbers = Randoms.pickUniqueNumbersInRange(MIN_RANGE, MAX_RANGE, TICKET_LEN).sorted()
        return (Lotto(numbers))
    }
}