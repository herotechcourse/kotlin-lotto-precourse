package lotto.domain

enum class Rank(val matchCount: Int, val prize: Long, val bonusBallRequired: Boolean = false) {
    FIRST(6, 2_000_000_000L),
    SECOND(5, 30_000_000L, true),
    THIRD(5, 1_500_000L),
    FOURTH(4, 50_000L),
    FIFTH(3, 5_000L);

    init {
        require(matchCount in 0..6) { "[ERR] Match count must be between 0 and 6." }
        require(prize >= 0) { "[ERR] Prize must be non-negative." }
    }

    companion object {
        fun from(matchCount: Int, bonusBallMatched: Boolean): Rank {
            return entries.firstOrNull { it.matchCount == matchCount && (!it.bonusBallRequired || bonusBallMatched) }
                ?: throw IllegalArgumentException("No matching rank found for matchCount: $matchCount and bonusBallMatched: $bonusBallMatched")
        }
    }
}

