package lotto.io

import lotto.Lotto
import lotto.LottoResultType
import lotto.LottoResultType.*
import lotto.util.LottoResultCalculator
import lotto.util.LottoResultCalculator.countResultType

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
        println("3 Matches (5,000 KRW) – ${countResultType(lottoResultTypes, FIFTH_PRIZE)} tickets")
        println("4 Matches (50,000 KRW) – ${countResultType(lottoResultTypes, FOURTH_PRIZE)} tickets")
        println("5 Matches (1,500,000 KRW) – ${countResultType(lottoResultTypes, THIRD_PRIZE)} tickets")
        println("5 Matches + Bonus Ball (30,000,000 KRW) – ${countResultType(lottoResultTypes, SECOND_PRIZE)} tickets")
        println("6 Matches (2,000,000,000 KRW) – ${countResultType(lottoResultTypes, FIRST_PRIZE)} tickets")
        println("Total return rate is ${String.format("%.1f", LottoResultCalculator.calculateReturnRate(lottoResultTypes, amount))}%.")
    }

}