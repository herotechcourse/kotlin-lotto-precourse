package lotto

class LottoService() {

    private var lottoTickets: List<Lotto> = emptyList()

    fun purchaseTickets(amount: Int) {
        val lottoGenerator = LottoGenerator()
        val numberOfTickets = amount / LottoConstants.TICKET_PRICE
        lottoTickets = List(numberOfTickets){
            lottoGenerator.createLottoTicket()
        }
    }

    fun getTickets(): List<Lotto> {
        return lottoTickets
    }

}