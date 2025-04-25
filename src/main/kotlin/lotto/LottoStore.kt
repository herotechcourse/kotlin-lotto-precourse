package lotto

class LottoStore(private val machine: LottoMachine) {

    fun sell(amount: Money): Lottos {
        val tickets: List<Lotto> = amount.payFor { machine.issue() }

        return Lottos(tickets)
    }

}
