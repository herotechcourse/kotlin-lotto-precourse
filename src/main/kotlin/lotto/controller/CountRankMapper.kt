package lotto.controller

import lotto.Rank
import lotto.WinningStatistics
import lotto.view.CountRankResponse

object CountRankMapper {

    fun toResponses(winningStatistics: WinningStatistics): List<CountRankResponse> = Rank.entries
        .filter { it != Rank.NONE }
        .map { rank -> CountRankResponse(rank, winningStatistics.getCount(rank)) }

}
