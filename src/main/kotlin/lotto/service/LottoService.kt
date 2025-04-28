package lotto.service

import camp.nextstep.edu.missionutils.Randoms
import lotto.domain.Lotto
import lotto.domain.Rank
import lotto.domain.WinningNumbers

data class Statistics(val rankCounts: Map<Rank, Int>) {
    val totalPrize: Long
        get() = rankCounts.entries.sumOf { (rank, count) -> rank.prize * count }
}

object LottoService {
    fun generateTickets(amount: Int): List<Lotto> {
        val count = amount / 1_000
        return List(count) {
            Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted())
        }
    }

    fun calculateStatistics(
        tickets: List<Lotto>,
        winning: WinningNumbers
    ): Statistics {
        val counts = tickets
            .map { lotto -> Rank.of(lotto.numbers(), winning.mainNumbers(), winning.bonusNumber()) }
            .groupingBy { it }
            .eachCount()
        return Statistics(counts)
    }
}
