package lotto.view

import lotto.Lotto

class OutputView {
    private val printWinningCriteria: Map<Int, String> = mapOf(
        Pair(5_000, "3 Matches (5,000 KRW)"),
        Pair(50_000, "4 Matches (50,000 KRW)"),
        Pair(1_500_000, "5 Matches (1,500,000 KRW)"),
        Pair(30_000_000, "5 Matches + Bonus Ball (30,000,000 KRW)"),
        Pair(2_000_000_000, "6 Matches (2,000,000,000 KRW)"),
    )

    fun showPurchasedLotto (amount: Int, lottos: List<Lotto>) {
        println("You have purchased $amount tickets.")
        lottos.forEach { lotto: Lotto ->  println( lotto.getNumbers().sorted()) }
    }

    fun showResultStatistics (matchs: Map<Int, Int>, roi: Double) {
        println("Winning Statistics")
        println("---")
        matchs.forEach { prize: Int, cnt: Int -> println("${printWinningCriteria[prize]} - $cnt tickets") }
        println("Total return rate is $roi%.")
    }

}