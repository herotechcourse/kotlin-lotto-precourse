package lotto

enum class LottoRanks(val code: String, val countOfMatches: Int, val prize: Int) {
    MATCH_3("match_3", 3, 5000),
    MATCH_4("match_4", 4, 50000),
    MATCH_5("match_5", 5, 1500000),
    MATCH_5_AND_BONUS("match_5_and_bonus", 5, 30000000),
    MATCH_6("match_6", 6, 2000000000)
}
