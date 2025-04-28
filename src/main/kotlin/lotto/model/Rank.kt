package lotto.model

enum class Rank(
    val matchCount: Int,
    val prize: Int,
    val description: String
) {
    FIRST(6, 2_000_000_000, "Matches"),
    SECOND(5, 30_000_000, "Matches + Bonus Ball"),
    THIRD(5, 1_500_000, "Matches"),
    FOURTH(4, 50_000, "Matches"),
    FIFTH(3, 5_000, "Matches"),
    NONE(0, 0, "");

    companion object {
        fun initialResult(): MutableMap<Rank, Int> =
            entries
                .associateWith { 0 }
                .toMutableMap()

        fun from(matchCount: Int, bonusMatch: Boolean): Rank {
            return when {
                matchCount == 6 -> FIRST
                matchCount == 5 && bonusMatch -> SECOND
                matchCount == 5 -> THIRD
                matchCount == 4 -> FOURTH
                matchCount == 3 -> FIFTH
                else -> NONE
            }
        }
    }
}
