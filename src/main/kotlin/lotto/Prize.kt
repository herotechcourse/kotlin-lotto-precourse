package lotto

@JvmInline
value class Prize(val amount: Long) : Comparable<Prize> {

    init {
        require(amount >= 0L) { "Prize must not be negative." }
        require(amount % UNIT == 0L) { "Prize must be divisible by $UNIT." }
    }

    operator fun plus(other: Prize): Prize = Prize(amount + other.amount)

    operator fun times(other: Int): Prize = Prize(amount * other)

    operator fun div(other: Money): Double = (this.amount.toDouble() / other.amount)

    override fun compareTo(other: Prize): Int = this.amount.compareTo(other.amount)

    companion object {
        private const val UNIT = 1_000L

        val ZERO = Prize(0L)
    }
}
