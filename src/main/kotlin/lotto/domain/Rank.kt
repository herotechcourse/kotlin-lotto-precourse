package lotto.domain

/**
 * Represents the prize tiers in the lottery game.
 *
 * Each rank is defined by:
 * - The number of matching numbers required
 * - Whether the bonus number must also match
 * - The associated prize amount (in KRW)
 *
 * Use [from] to determine the correct [Rank] based on a ticket's match count and bonus number match.
 *
 * Example:
 * ```
 * val rank = Rank.from(5, true) // Returns SECOND
 * ```
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
    FIFTH(3, false, 5_000);

    companion object {
        fun from(matchCount: Int, bonusMatch: Boolean): Rank? {
            return Rank.entries.find { it.matchCount == matchCount && it.matchBonus == bonusMatch }
                ?: Rank.entries.find { it.matchCount == matchCount && !it.matchBonus }
        }
    }
}