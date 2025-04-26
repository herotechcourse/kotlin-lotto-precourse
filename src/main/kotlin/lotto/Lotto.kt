package lotto

class Lotto(numbers: List<Int>) {
    private val numbers: List<Int> = numbers.sorted()

    init {
        require(numbers.size == 6) { "[ERROR] Lotto must contain exactly 6 numbers." }
        require(numbers.distinct().size == 6) { "[ERROR] Lotto numbers must be unique." }
        require(numbers.all { it in 1..45 }) { "[ERROR] Lotto numbers must be between 1 and 45." }
    }

    fun getNumbers(): List<Int> = numbers
    fun countMatchingNumbers(winningNumbers: List<Int>): Int = numbers.intersect(winningNumbers).size
    fun contains(number: Int): Boolean = numbers.contains(number)

    override fun toString(): String = numbers.joinToString(", ", prefix = "[", postfix = "]")
}

enum class Rank(val matchCount: Int, val hasBonus: Boolean, val prize: Long) {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    NONE(0, false, 0);

    companion object {
        fun valueOf(matchCount: Int, hasBonus: Boolean): Rank {
            return when {
                matchCount == 6 -> FIRST
                matchCount == 5 && hasBonus -> SECOND
                matchCount == 5 -> THIRD
                matchCount == 4 -> FOURTH
                matchCount == 3 -> FIFTH
                else -> NONE
            }
        }
    }
}
