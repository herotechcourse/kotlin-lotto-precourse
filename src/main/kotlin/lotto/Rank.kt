package lotto

enum class Rank(val matchCount: Int, val hasBonus: Boolean, val prize: Int) {
    FIRST(6, false, 2000000000),
    SECOND(5, true, 30000000),
    THIRD(5, false, 1500000),
    FOURTH(4, false, 50000),
    FIFTH(3, false, 5000),
    MISS(0, false, 0);

    companion object {
        fun of(matchCount: Int, hasBonus: Boolean): Rank {
            for (rank in values()) {
                if (rank.matchCount == matchCount && rank.hasBonus == hasBonus) {
                    return rank
                }
            }

            for (rank in values()) {
                if (rank.matchCount == matchCount) {
                    return rank
                }
            }

            return MISS
        }
    }
}