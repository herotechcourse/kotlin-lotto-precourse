package lotto

import lotto.util.LottoGenerator
import lotto.util.RandomLottoGenerator

class LottoMachine(private val generator: LottoGenerator = RandomLottoGenerator) {
    private val pricePerTicket = Config.PRICE_PER_TICKET

    fun issueBundle(amount: Int): List<Lotto> {
        val validatedAmount = validateAmount(amount)
        val count = calculateTicketCount(validatedAmount)
        val bundle = List(count) { Lotto(generator.generateNumbers()) }
        return bundle
    }

    private fun validateAmount(amount: Int): Int {
        require(amount >= pricePerTicket) { "[ERROR] Amount must be at least ${pricePerTicket}." }
        require(amount % pricePerTicket == 0) { "[ERROR] Amount must be divisible by ${pricePerTicket}." }
        return amount
    }

    private fun calculateTicketCount(amount: Int): Int {
        return amount / pricePerTicket
    }

}