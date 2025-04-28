package lotto

enum class Rank(val matchCount: Int, val hasBonus: Boolean, val prizeMoney: Int) {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    NONE(0, false, 0);

    companion object {
        fun from(matchCount: Int, hasBonus: Boolean): Rank {
            if (matchCount == 5 && hasBonus) {
                return SECOND
            }
            return values()
                .filter { it.matchCount == matchCount && !it.hasBonus }
                .firstOrNull() ?: NONE
        }
    }
}