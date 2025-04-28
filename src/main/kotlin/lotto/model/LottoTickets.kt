package lotto.model

import lotto.Lotto
import lotto.util.RandomGenerator

class LottoTickets(
    ticketCount: Int
) {
    // Stores the list of generated Lotto tickets
    private val tickets: List<Lotto> = List(ticketCount) {
        // Generate a Lotto ticket with random unique numbers
        Lotto(RandomGenerator.generateLottoNumbers())
    }

    // Returns the list of Lotto tickets
    fun getTickets(): List<Lotto> {
        return tickets
    }
}
