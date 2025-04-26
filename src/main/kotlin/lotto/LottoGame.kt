package lotto

import camp.nextstep.edu.missionutils.Randoms

class LottoGame(
    val purchaseAmount: UInt,
    val winningNumbers: List<Int>,
    val bonusNumber: Int,
    val numberOfTickets: Int
) {
    private val tickets = mutableListOf<Lotto>()

    init {
        createMultipleTickets(numberOfTickets)
    }

    fun getTickets(): List<Lotto> {
        return tickets.toList()
    }

    private fun createSingleTicket(): Lotto {
        val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
        return Lotto(numbers)
    }

    private fun createMultipleTickets(numberOfTickets: Int) {
        repeat(numberOfTickets) {
            tickets.add(createSingleTicket())
        }
    }
}
