package lotto

enum class MatchCondition(val label: String) {
    MATCH_6("6 Matches (2,000,000,000 KRW)"),
    MATCH_5_AND_BONUS("5 Matches + Bonus Ball (30,000,000 KRW)"),
    MATCH_5("5 Matches (1,500,000 KRW)"),
    MATCH_4("4 Matches (50,000 KRW)"),
    MATCH_3("3 Matches (5,000 KRW)")
}
