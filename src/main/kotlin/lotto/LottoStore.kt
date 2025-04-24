package lotto

class LottoStore(private val machine: LottoMachine) {

    fun sell(amount: Long): Lottos {
        val money = Money(amount)
        val tickets: List<Lotto> = money.payFor { machine.issue() }

        return Lottos(tickets)
    }

}

@JvmInline
value class Money(private val amount: Long) {
    init {
        require(amount % UNIT == 0L) { "Money must be divisible by $UNIT." }
        require(amount >= 0L) { "Money must not be negative." }
    }

    fun isZero(): Boolean = amount == 0L

    fun <T> payFor(action: () -> T): List<T> = List((amount / UNIT).toInt()) { action() }

    operator fun div(other: Money): Double = (this.amount.toDouble() / other.amount)

    companion object {
        private const val UNIT = 1_000L

        fun fromTicketCount(count: Int): Money {
            return Money(count * UNIT)
        }
    }
}
