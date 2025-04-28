package lotto.domain

import lotto.Lotto
import lotto.util.NumberGenerator

/**
 * Issues Lotto tickets based on the purchase amount.
 *
 * @param generator produces the numbers for each ticket
 */
class TicketMachine(private val generator: NumberGenerator): ITicketMachine {

    /**
     * Issues one Lotto ticket per 1,000 KRW in [amount].
     */
    override fun issue(amount: Int): List<Lotto> {
        val count = amount / 1000
        return List(count) { Lotto(generator.generate()) }
    }
}
