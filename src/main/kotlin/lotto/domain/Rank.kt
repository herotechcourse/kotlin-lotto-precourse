package lotto.domain

enum class Rank(val label: String, val prize: Long) {
    ZERO("0 Matches", 0),
    THREE("3 Matches", 5_000),
    FOUR("4 Matches", 50_000),
    FIVE("5 Matches", 1_500_000),
    FIVE_BONUS("5 Matches + Bonus Ball", 30_000_000),
    SIX("6 Matches", 2_000_000_000)
}