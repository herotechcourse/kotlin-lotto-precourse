package lotto.process

import camp.nextstep.edu.missionutils.Randoms
import lotto.Lotto
import lotto.PurchaseAmount

class TicketGenerator {

    fun generateTickets(purchaseAmount: PurchaseAmount): List<Lotto>{
        val numberOfTickets = purchaseAmount.getNumberOfTickets()
        val tickets = mutableListOf<Lotto>()
        for (i in 1..numberOfTickets) {
            val randomNumbers = generateRandomLottoNumbers()
            tickets.add(Lotto(randomNumbers))
        }
        return tickets
    }

    private fun generateRandomLottoNumbers(): List<Int> {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted()
    }
}