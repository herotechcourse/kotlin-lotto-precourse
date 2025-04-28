package lotto.domain

import lotto.view.messages.RankMessages

enum class LottoRank (
    private val matchCount: Int,
    val prizeMoney: Int
) {
    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000),
    NONE(0, 0);

    fun getResultMessage(count: Int): String {
        if (this == SECOND) {
            return RankMessages.SECOND.with(prizeMoney.format(), count)
        }
        return RankMessages.GENERAL.with(matchCount, prizeMoney.format(), count)
    }

    companion object {

        fun findBy(matchCount: Int, bonusMatched: Boolean): LottoRank {
            return when {
                matchCount == 6 -> FIRST
                matchCount == 5 && bonusMatched -> SECOND
                matchCount == 5 -> THIRD
                matchCount == 4 -> FOURTH
                matchCount == 3 -> FIFTH
                else -> NONE
            }
        }
    }

    private fun Int.format() = "%,d".format(this)
}
