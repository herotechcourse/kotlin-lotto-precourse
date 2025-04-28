package lotto

import camp.nextstep.edu.missionutils.Randoms

class TicketMachine {
    fun generateTickets(purchaseAmount: Int): List<Lotto> {
        val count = purchaseAmount / Config.TICKET_PRICE
        return (1..count).map {
            val numbers = Randoms
                .pickUniqueNumbersInRange(
                    Config.MIN_LOTTO_NUMBER,
                    Config.MAX_LOTTO_NUMBER,
                    Config.LOTTO_NUMBER_COUNT
                )
                .sorted()
            Lotto(numbers)
        }
    }
}
