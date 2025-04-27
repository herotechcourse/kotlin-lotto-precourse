package lotto

enum class Rank(val matches: String, val winning: Int) {
    THREE("3 Matches", 5000),
    FOUR("4 Matches", 50000),
    FIVE("5 Matches", 1500000),
    BONUS("5 Matches + Bonus Ball", 30000000),
    SIX("6 Matches", 2000000000);
}