package lotto

@JvmInline
value class Money(val amount: Int) {
    init {
        require(amount in UNIT..MAX) { "Money must be between $UNIT and $MAX." }
        require(amount % UNIT == 0) { "Money must be divisible by $UNIT." }
    }

    fun <T> payFor(action: () -> T): List<T> = List((amount / UNIT)) { action() }

    companion object {
        private const val UNIT = 1_000
        private const val MAX = (Int.MAX_VALUE / 1000) * 1000

        fun fromTicketCount(count: Int): Money {
            return Money(count * UNIT)
        }
    }
}
