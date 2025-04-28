package lotto.domain.model

enum class Rank(
    val matchCount: Int,
    val prizeMoney: Int,
    val message: String
) {
    FIRST(6, 2_000_000_000, "6 Matches (2,000,000,000 KRW)"),
    SECOND(5, 30_000_000, "5 Matches + Bonus Ball (30,000,000 KRW)"),
    THIRD(5, 1_500_000, "5 Matches (1,500,000 KRW)"),
    FOURTH(4, 50_000, "4 Matches (50,000 KRW)"),
    FIFTH(3, 5_000, "3 Matches (5,000 KRW)"),
    NONE(0, 0, "");
}
