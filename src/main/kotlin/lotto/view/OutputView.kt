package lotto.view

import lotto.domain.PrizeRank
import lotto.observer.ILottoObserver
import lotto.observer.LottoObserver

class OutputView(private val observer: ILottoObserver = LottoObserver) : IOutputView {

    override fun printTickets(tickets: List<List<Int>>) {
        observer.println("You have purchased ${tickets.size} tickets.")
        tickets.forEach { observer.println(it) }
        observer.println("")
    }

    override fun printStatistics(resultCounts: Map<PrizeRank, Int>, returnRate: Double) {
        val statistics = """
        Winning Statistics
        ---
        3 Matches (5,000 KRW) – ${resultCounts.getOrDefault(PrizeRank.FIFTH, 0)} tickets
        4 Matches (50,000 KRW) – ${resultCounts.getOrDefault(PrizeRank.FOURTH, 0)} tickets
        5 Matches (1,500,000 KRW) – ${resultCounts.getOrDefault(PrizeRank.THIRD, 0)} tickets
        5 Matches + Bonus Ball (30,000,000 KRW) – ${resultCounts.getOrDefault(PrizeRank.SECOND, 0)} tickets
        6 Matches (2,000,000,000 KRW) – ${resultCounts.getOrDefault(PrizeRank.FIRST, 0)} tickets
        Total return rate is $returnRate%.
        """.trimIndent()

        observer.println(statistics)
    }

    override fun printError(message: String) {
        observer.println("[ERROR]: $message")
    }
}
