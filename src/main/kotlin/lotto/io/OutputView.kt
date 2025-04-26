package lotto.io

import lotto.Lotto
import lotto.LottoResultType
import lotto.LottoResultType.*

object OutputView {

    fun printLottos(lottos: List<Lotto>) {
        println("You have purchased ${lottos.size} tickets.")
        for (lotto in lottos) {
            println(lotto)
        }
        println()
    }

    fun printResult(lottoResultTypes: List<LottoResultType>, amount: Int) {
        println("Winning Statistics")
        println("---")
        println("3 Matches (5,000 KRW) – ${countMatches(lottoResultTypes, FIFTH_PRIZE)} tickets")
        println("4 Matches (50,000 KRW) – ${countMatches(lottoResultTypes, FOURTH_PRIZE)} tickets")
        println("5 Matches (1,500,000 KRW) – ${countMatches(lottoResultTypes, THIRD_PRIZE)} tickets")
        println("5 Matches + Bonus Ball (30,000,000 KRW) – ${countMatches(lottoResultTypes, SECOND_PRIZE)} tickets")
        println("6 Matches (2,000,000,000 KRW) – ${countMatches(lottoResultTypes, FIRST_PRIZE)} tickets")

        val rate = LottoResultType.calculate(lottoResultTypes).toDouble() / (amount * 1000) * 100
        println("Total return rate is ${String.format("%.1f", rate)}%.")
    }

    private fun countMatches(lottoResultTypes: List<LottoResultType>, lottoResultType: LottoResultType): Int {
        return lottoResultTypes.count() { matchResult -> matchResult == lottoResultType }
    }

}