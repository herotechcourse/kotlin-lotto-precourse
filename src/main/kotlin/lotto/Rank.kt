package lotto

enum class Rank (countOfMatches: Int, prizeMoney: Int) {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    NONE (0,0);

    fun findRank(countOfMatches: Int, countOfMatchesBonus: Int): Rank
    {
        if (countOfMatches == 6) { return FIRST }
        if (countOfMatches == 5 && countOfMatchesBonus == 1){ return SECOND }
        if (countOfMatches == 5) { return THIRD }
        if (countOfMatches == 4) { return FOURTH }
        if (countOfMatches == 3) { return FIFTH }
        return NONE
    }
}