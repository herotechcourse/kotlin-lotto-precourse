package lotto

enum class PrizeRank(val matchingCount: Int, val prizeAmount: Int) {

    NONE(0, 0),
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000);

    companion object {
        fun findBy(matchingCount: Int, hasBonusNumber: Boolean): PrizeRank {
            if (matchingCount == SECOND.matchingCount) {
                return judgeIfMatchingCountIsSame(hasBonusNumber)
            }
            return entries.firstOrNull { it.matchingCount == matchingCount } ?: NONE
        }

        private fun judgeIfMatchingCountIsSame(hasBonusNumber: Boolean): PrizeRank {
            if (hasBonusNumber) {
                return SECOND
            }
            return THIRD
        }
    }
}
