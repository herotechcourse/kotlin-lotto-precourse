package lotto.domain
import lotto.Lotto
import lotto.support.Message
import camp.nextstep.edu.missionutils.Randoms
import lotto.view.OutputView

class LottoMachine (private val purchaseAmount: Int){
    val tickets: List<Lotto>

    init {
        require(purchaseAmount >= TICKET_PRICE) { Message.ERROR_AMOUNT_TOO_SMALL }
        require(purchaseAmount % TICKET_PRICE == 0) { Message.ERROR_AMOUNT_NOT_DIVISIBLE }
        tickets = generateTickets()
        OutputView.printTickets(tickets)
    }
    private fun generateTickets(): List<Lotto> {
        val ticketCount = purchaseAmount / TICKET_PRICE
        return List(ticketCount) {
            Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6))
        }
    }
    companion object {
        private const val TICKET_PRICE = 1000
    }
}