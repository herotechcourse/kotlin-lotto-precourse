package lotto.view

import lotto.Lotto
import lotto.domain.LottoResult

object OutputView {

    fun showPurchaseLotto(count: Int, lottos: List<Lotto>) {
        println()
        println("You have purchased $count tickets.")
        lottos.forEach { println(it) }
        println()
    }

    fun showLottoResult(lottoResultMap: Map<LottoResult, Int>) {
        println()
        println("Winning Statistics")
        println("---")
        LottoResult.entries.forEach { result ->
            val matchingCount = result.matchingCount
            val winningAmount = result.winningAmount
            val count = lottoResultMap[result] ?: 0
            val rankName = result.name

            print("$matchingCount Matches")
            if (rankName == "SECOND_PLACE") {
                print(" + Bonus Ball")
            }
            println(" (${String.format("%,d", winningAmount)} KRW) – $count tickets")
        }
    }

    fun showEarningRate(earningRate: String) {
        println("Total return rate is $earningRate%.")
    }
}
