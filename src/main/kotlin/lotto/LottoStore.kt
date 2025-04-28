package lotto

class LottoStore(private val machine: LottoMachine = RandomLottoMachine) {

    fun sell(amount: Money): LottoTickets {
        val tickets: List<Lotto> = amount.payFor { machine.issue() }

        return LottoTickets(tickets)
    }

}
