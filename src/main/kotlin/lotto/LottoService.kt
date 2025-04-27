package lotto

class LottoService() {

    private var lottoTickets: List<Lotto> = emptyList()
    private var winnerNumbers: List<Int> = emptyList()
    private var bonusNumber: Int = -1

    fun purchaseTickets(amount: Int) {
        val lottoGenerator = LottoGenerator()
        val numberOfTickets = amount / LottoConstants.TICKET_PRICE
        lottoTickets = List(numberOfTickets) {
            lottoGenerator.createLottoTicket()
        }
    }

    fun getTickets(): List<Lotto> {
        return lottoTickets
    }

    fun setWinnerNumbers(numbers: List<Int>) {
        winnerNumbers = numbers
    }

    fun setBonusNumber(number: Int) {
        bonusNumber = number
    }

    fun getWinnerNumbers(): List<Int> {
        return winnerNumbers
    }

    fun getBonusNumber(): Int {
        return bonusNumber
    }

    fun compareTickets(): MutableMap<Rank, Int> {
        val rankCounts = mutableMapOf<Rank, Int>()

        for (rank in Rank.entries) {
            rankCounts[rank] = 0
        }
        lottoTickets.forEach { ticket ->
            val hits = ticket.countHits(winnerNumbers)
            val hasBonus = ticket.containsBonus(bonusNumber)
            val rank = Rank.from(hits, hasBonus)
            rankCounts[rank] = rankCounts.getValue(rank) + 1
        }
        return rankCounts
    }

}