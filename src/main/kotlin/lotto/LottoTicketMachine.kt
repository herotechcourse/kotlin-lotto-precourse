package lotto

class LottoTicketMachine {
    fun buyLotto(quantity: PurchaseAmountDto, ticket: List<LottoTicketDto>) : List<Lotto> {
        return ticket.map { Lotto(it.numbers) }
    }
}
