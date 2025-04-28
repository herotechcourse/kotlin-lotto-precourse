package lotto

object OutputView {
    fun displayTickets(lottoList: List<Lotto>) {
        println("You have purchased ${lottoList.size} tickets.")
        for (lotto in lottoList) {
            lotto.displayNumbers()
        }
        println()
    }

    fun displayWinningStatistics(matched: Array<Int>, returnRate: Double) {
        println("Winning Statistics")
        println("---")
        println("3 Matches (5,000 KRW) – ${matched[Prize.MATCHED3.index]} tickets")
        println("4 Matches (50,000 KRW) – ${matched[Prize.MATCHED4.index]} tickets")
        println("5 Matches (1,500,000 KRW) – ${matched[Prize.MATCHED5.index]} tickets")
        println("5 Matches +Bonus Ball (30,000,000 KRW) – ${matched[Prize.`MATCHED-BONUS`.index]} tickets")
        println("6 Matches (2,000,000,000 KRW) – ${matched[Prize.MATCHED6.index]} tickets")
        println("Total return rate is ${String.format("%.1f", returnRate)} %.")
        println()
    }
}