package lotto

enum class PrizeRank(
    val matchCount: Int,
    val requiresBonus: Boolean,
    val amount: Int
) {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000);
}

class Lotto(private val numbers: Set<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] Lotto must contain exactly 6 numbers." }
    }

    companion object {
        const val TICKET_PRICE = 1000
        const val MIN_NUMBER = 1
        const val MAX_NUMBER = 45
        const val NUMBERS_PER_TICKET = 6
    }

    private var tickets = mutableListOf<Set<Int>>()
    private lateinit var winningNumbers: Set<Int>
    private var bonusNumber: Int = 0
}
