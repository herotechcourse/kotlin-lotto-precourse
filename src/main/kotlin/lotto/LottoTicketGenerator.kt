package lotto

interface LottoTicketGenerator {
    fun generateNumberOfTickets(purchaseAmount: Int): Int
    fun generateTickets(numberOfTickets: Int): List<Lotto>
    fun generateRandomNumbersInRange(): List<Int>
}

class LottoTicketGeneratorImpl(private val randomNumbersGeneratorWrapper: RandomNumbersGeneratorWrapper) :
    LottoTicketGenerator {
    override fun generateNumberOfTickets(purchaseAmount: Int): Int {
        val numberOfTickets = purchaseAmount / DIVISOR
        return numberOfTickets
    }

    override fun generateTickets(numberOfTickets: Int): List<Lotto> {
        val tickets = mutableListOf<Lotto>()
        repeat(numberOfTickets) {
            val singleTicket = generateRandomNumbersInRange().sorted()
            val lottoTicket = Lotto(singleTicket)
            tickets.add(lottoTicket)
        }
        return tickets
    }

    override fun generateRandomNumbersInRange(): List<Int> {
        return randomNumbersGeneratorWrapper.generateRandomNumbersInRange(LOWER_RANGE, UPPER_RANGE, REQUIRED_COUNT)
    }

    companion object {
        private const val DIVISOR = 1000
        private const val LOWER_RANGE = 1
        private const val UPPER_RANGE = 45
        private const val REQUIRED_COUNT = 6
    }
}