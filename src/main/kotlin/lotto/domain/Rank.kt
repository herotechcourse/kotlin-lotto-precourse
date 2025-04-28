package lotto.domain

/**
 * Represents the prize ranks based on matching numbers and bonus ball.
 *
 * @property matchCount number of regular numbers needed to match
 * @property matchBonus whether bonus number match is required
 * @property prize prize money for the rank
 */
enum class Rank(
    val matchCount: Int,
    val matchBonus: Boolean,
    val prize: Int
) {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    NONE(0, false, 0);

    companion object {
        /**
         * Finds the Rank based on how many numbers matched and whether bonus number matched.
         *
         * @param matchCount number of numbers matched
         * @param matchBonus whether the bonus ball also matched
         * @return the corresponding Rank
         */
        fun find(matchCount: Int, matchBonus: Boolean): Rank {
            return when {
                matchCount == 6 -> FIRST
                matchCount == 5 && matchBonus -> SECOND
                matchCount == 5 -> THIRD
                matchCount == 4 -> FOURTH
                matchCount == 3 -> FIFTH
                else -> NONE
            }
        }
    }
}
