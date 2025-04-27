package lotto

import camp.nextstep.edu.missionutils.Console

object OutputView {
    fun displayTickets(lottoList: List<Lotto>) {
        println("You have purchased ${lottoList.size} tickets.")
        for (lotto in lottoList) {
            lotto.displayNumbers()
        }
    }

    fun displayWinningStatistics(matched: List<Int>, returnRate: Float) {
        println("Winning Statistics")
        print("---")
        print("3 Matches (5, 000 KRW) – ${matched[Prize.MATCHED3.index]} tickets")
        print("4 Matches (50, 000 KRW) – ${matched[Prize.MATCHED4.index]} tickets")
        print("5 Matches (1, 500, 000 KRW) – ${matched[Prize.MATCHED5.index]} tickets")
        print("5 Matches +Bonus Ball (30, 000, 000 KRW) – ${matched[Prize.`MATCHED-BONUS`.index]} tickets")
        print("6 Matches (2, 000, 000, 000 KRW) – ${matched[Prize.MATCHED6.index]} tickets")
        print("Total return rate is ${String.format("%.1f", returnRate)} %.")
    }
}