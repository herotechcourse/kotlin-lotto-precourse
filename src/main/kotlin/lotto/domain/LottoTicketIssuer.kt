package lotto.domain

import camp.nextstep.edu.missionutils.Randoms
import lotto.Lotto

class LottoTicketIssuer {
    private fun getPurchasableTicketCount(purchaseAmount: Int): Int {
        return purchaseAmount / LottoConstants.Ticket.PRICE
    }

    private fun generateLottoNumbers(): Lotto {
        return Randoms.pickUniqueNumbersInRange(
                        LottoConstants.NumberRange.MIN,
                        LottoConstants.NumberRange.MAX,
                        LottoConstants.Ticket.SIZE
                )
                .sorted()
                .let { Lotto(it) }
    }

    fun issueLottoTickets(purchaseAmount: Int): List<Lotto> {
        val ticketCount = getPurchasableTicketCount(purchaseAmount)
        return List(ticketCount) { generateLottoNumbers() }
    }
}
