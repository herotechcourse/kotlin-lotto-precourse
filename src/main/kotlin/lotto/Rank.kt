package lotto

enum class Rank(val rank: Int, val matchCount: IntRange, val isBonusNumberRequired: Boolean, val price: Int) {
    FIRST_PRIZE(1, 6..6, false, 2000_000_000),
    SECOND_PRIZE(2, 5..5, true, 30_000_000),
    THIRD_PRIZE(3, 5..5,false,  1_500_000),
    FOURTH_PRIZE(4, 4..4,false, 50_000),
    FIFTH_PRIZE(5, 3..3, false, 5_000),
    NONE(-1, 0..2, false, 0);

    companion object {
        fun getRank(matchCount: Int, bonusNumberMatched: Boolean): Rank {
            return entries.find { rank ->
                matchCount in rank.matchCount &&
                        (rank.isBonusNumberRequired == bonusNumberMatched || !rank.isBonusNumberRequired)
            } ?: throw IllegalArgumentException("[ERROR] 잘못된 파라미터가 전달되었습니다.")
        }
    }
}
