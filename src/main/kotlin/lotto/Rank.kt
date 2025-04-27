package lotto.domain

// Represent the ranking of Lotto results based on matching numbers and bonus number
enum class Rank(val match: Int, val bonus: Boolean, val prize: Int) {

    // 1st: 6 matches, no bonus needed
    FIRST(6, false, 2_000_000_000),

    // 2nd: 5 matches + bonus number matched
    SECOND(5, true, 30_000_000),

    // 3rd: 5 matches, bonus number missed
    THIRD(5, false, 1_500_000),

    // 4th: 4 matches
    FOURTH(4, false, 50_000),

    // 5th: 3 matches
    FIFTH(3, false, 5_000),

    // No prize
    MISS(0, false, 0);

    // Utility functions related to rank
    companion object {

        // Return the rank based on number of matches and bonus status
        fun from(match: Int, hasBonus: Boolean): Rank = when {
            match == 6 -> FIRST
            match == 5 && hasBonus -> SECOND
            match == 5 -> THIRD
            match == 4 -> FOURTH
            match == 3 -> FIFTH
            else -> MISS
        }
    }
}