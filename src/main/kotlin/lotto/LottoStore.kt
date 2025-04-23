package lotto

class LottoStore(private val machine: LottoMachine) {

    fun sell(amount: Int): Lottos {
        require(amount % UNIT == 0) { "[ERROR] Purchase amount must be divisible by $UNIT." }

        val count = amount / UNIT
        val tickets = (1..count).map { machine.issue() }

        return Lottos(tickets)
    }

    companion object {
        private const val UNIT = 1_000
    }
}
