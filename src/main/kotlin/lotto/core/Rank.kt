package lotto.core

enum class Rank(val matches: Int, val prize: Long) {
    THREE(3, 5_000),
    FOUR(4, 50_000),
    FIVE(5, 1_500_000),
    FIVE_PLUS(5, 30_000_000),
    SIX(6, 2_000_000_000);

    companion object {
        fun of(matchCount: Int, hasBonus: Boolean): Rank? = when {
            matchCount == 6 -> SIX
            matchCount == 5 && hasBonus -> FIVE_PLUS
            matchCount == 5 -> FIVE
            matchCount == 4 -> FOUR
            matchCount == 3 -> THREE
            else -> null
        }
    }
}