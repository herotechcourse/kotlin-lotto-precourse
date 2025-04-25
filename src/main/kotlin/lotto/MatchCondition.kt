package lotto

enum class MatchCondition(val prize: Int) {
    MATCH_6(2_000_000_000),
    MATCH_5_AND_BONUS(30_000_000),
    MATCH_5(1_500_000),
    MATCH_4(50_000),
    MATCH_3(5_000)
}
