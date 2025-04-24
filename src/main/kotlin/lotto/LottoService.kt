package lotto

class LottoService() {

    private var winnerNumbers: List<Int>? = null
    private var bonusNumber: Int? = null
    private var lottoTickets: MutableList<Lotto> = mutableListOf()

    fun purchaseTickets(amount: Int) {
        val lottoGenerator = LottoGenerator()
        val numberOfTickets = amount / LottoConstants.TICKET_PRICE
        lottoTickets = MutableList(numberOfTickets){
            lottoGenerator.createLottoTicket()
        }
    }

    fun getTickets(): MutableList<Lotto> {
        return lottoTickets
    }

}