package lotto

class Lotto(private val numbers: List<Int>) {

    init {
        require(numbers.size == 6) { "[ERROR] Lotto must contain exactly 6 numbers." }
        require(numbers.distinct().size == 6) { "[ERROR] Lotto numbers must be unique." }
        require(numbers.all { it in 1..45 }) { "[ERROR] Lotto numbers must be between 1 and 45." }
    }

    fun getNumbers(): List<Int> = numbers

    fun matchCount(winning: Set<Int>): Int {
        return numbers.count { it in winning }
    }

    fun contains(number: Int): Boolean {
        return numbers.contains(number)
    }
}

enum class PrizeRank(
    val matchCount: Int,
    val requiresBonus: Boolean,
    val prizeAmount: Long
) {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000);

    companion object {
        fun findByMatch(matchCount: Int, bonusMatch: Boolean): PrizeRank? {
            return when (matchCount) {
                6 -> FIRST
                5 -> if (bonusMatch) SECOND else THIRD
                4 -> FOURTH
                3 -> FIFTH
                else -> null
            }
        }
    }
}
