package lotto.view.output

import lotto.LottosResult

object DisplayWinningStatisticsOutputView : OutputView<LottosResult> {
    override fun display(model: LottosResult) {
        val result = model.result
        val profit = model.calculateProfitRate()

        println("Winning Statistics")
        println("---")
        println("3 Matches (5,000 KRW) – ${result["3"]} tickets")
        println("4 Matches (50,000 KRW) – ${result["4"]} tickets")
        println("5 Matches (1,500,000 KRW) – ${result["5"]} tickets")
        println("5 Matches + Bonus Ball (30,000,000 KRW) – ${result["5+bonus"]} tickets")
        println("6 Matches (2,000,000,000 KRW) – ${result["6"]} tickets")
        println("Total return rate is $profit.")
    }
}