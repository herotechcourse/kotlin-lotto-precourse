package lotto.controller

import lotto.Lotto
import lotto.LottoTickets
import lotto.Rank
import lotto.WinningStatistics
import lotto.view.CountRankResponse

object ResponseMapper {

    fun toResponses(lottoTickets: LottoTickets): List<List<Int>> = lottoTickets.getTickets().map(Lotto::getNumbers)

    fun toResponses(winningStatistics: WinningStatistics): List<CountRankResponse> = Rank.entries
        .filter { it != Rank.NONE }
        .map { rank -> CountRankResponse(rank, winningStatistics.getCount(rank)) }

}
