package lotto.output

import lotto.Lotto
import lotto.process.LottoRank
import java.math.BigDecimal

class OutputView {

    fun generateLottoResult(lottoRanks: List<LottoRank>){
        println("\nWinning Statistics\n---")
        println("3 Matches (5,000 KRW) – ${countRank(LottoRank.FIFTH, lottoRanks)} tickets")
        println("4 Matches (50,000 KRW) – ${countRank(LottoRank.FOURTH, lottoRanks)} tickets")
        println("5 Matches (1,500,000 KRW) – ${countRank(LottoRank.THIRD, lottoRanks)} tickets")
        println("5 Matches + Bonus Ball (30,000,000 KRW) – ${countRank(LottoRank.SECOND, lottoRanks)} tickets")
        println("6 Matches (2,000,000,000 KRW) – ${countRank(LottoRank.FIRST, lottoRanks)} tickets")
    }

    fun generateReturnRate(returnRate: BigDecimal){
        println("Total return rate is ${returnRate.toPlainString()}%.")
    }

    fun displayTickets(purchasedTickets : List<Lotto>){
        println("\nYou have purchased ${purchasedTickets.size} tickets.")
        purchasedTickets.forEach { println(it) }
    }

    private fun countRank(lottoRank: LottoRank, lottoRanks: List<LottoRank>): Long {
        return lottoRanks.stream().filter { it.equals(lottoRank) }.count()
    }
}