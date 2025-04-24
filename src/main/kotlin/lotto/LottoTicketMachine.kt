package lotto

class LottoTicketMachine {
    fun buyLotto(quantity: PurchaseQuantityDto, ticket: List<LottoTicketDto>) : List<Lotto> {
        return ticket.map { Lotto(it.numbers) }
    }
}