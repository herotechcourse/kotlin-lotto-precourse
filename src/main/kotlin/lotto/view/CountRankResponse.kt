package lotto.view

import lotto.Rank

data class CountRankResponse(
    val matchCount: Int,
    val prize: Long,
    val bonusMatch: Boolean,
    val count: Int
) {

    constructor(rank: Rank, count: Int) : this(
        matchCount = rank.matchCount,
        bonusMatch = rank.bonusMatch,
        prize = rank.prize.amount,
        count = count
    )

}
