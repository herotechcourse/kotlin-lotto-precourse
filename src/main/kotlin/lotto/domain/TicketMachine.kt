package lotto.domain

import lotto.Lotto
import lotto.util.NumberGenerator

/**
 * Issues Lotto tickets based on the purchase amount.
 *
 * @param generator produces the numbers for each ticket
 */
class TicketMachine(private val generator: NumberGenerator) {

    /**
     * Issues one Lotto ticket per 1,000 KRW in [amount].
     */
    fun issue(amount: Int): List<Lotto> {
        val count = amount / 1000
        return List(count) { Lotto(generator.generate()) }
    }
}
