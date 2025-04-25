package lotto

@JvmInline
value class Money(private val amount: Int) {
    init {
        require(amount % UNIT == 0) { "Money must be divisible by $UNIT." }
        require(amount >= 0) { "Money must not be negative." }
        require(amount <= MAX_ALLOWED) { "Money must not exceed $MAX_ALLOWED." }
    }

    fun isZero(): Boolean = amount == 0

    fun <T> payFor(action: () -> T): List<T> = List((amount / UNIT)) { action() }

    operator fun div(other: Money): Double = (this.amount.toDouble() / other.amount)

    companion object {
        private const val UNIT = 1_000
        private const val MAX_ALLOWED = (Int.MAX_VALUE / 1000) * 1000

        fun fromTicketCount(count: Int): Money {
            return Money(count * UNIT)
        }
    }
}
