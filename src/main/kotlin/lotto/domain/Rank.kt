package lotto.domain

enum class Rank(
    val prize: Long,
    val description: String
) {
    FIRST(5_000, "3 Matches"),
    SECOND(50_000, "4 Matches"),
    THIRD(1_500_000, "5 Matches"),
    FOURTH(30_000_000, "5 Matches + Bonus Ball"),
    FIFTH(2_000_000_000, "6 Matches"),
    NONE(0, "No Matches");
}