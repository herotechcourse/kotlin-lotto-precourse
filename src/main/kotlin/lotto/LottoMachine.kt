package lotto

class LottoMachine {
    private val lottoGenerator = LottoGenerator()
    private val ticketPrice = 1000

    fun generateTickets(money: Int): List<Lotto> {
        require(money >= ticketPrice) { "[ERROR] Purchase amount must be at least $ticketPrice KRW." }
        require(money % ticketPrice == 0) { "[ERROR] Purchase amount must be a multiple of $ticketPrice KRW." }

        val ticketCount = money / ticketPrice
        return List(ticketCount) { lottoGenerator.generate() }
    }

}