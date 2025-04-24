package lotto

import java.util.Locale

object OutputView {
    fun printLottos(lottos: List<Lotto>) {
        println("You have purchased ${lottos.size} tickets.")
        lottos.forEach {
            println(it.getNumbers().joinToString(", ", "[", "]"))
        }
    }

    fun printResult(result: LottoResult) {
        println()
        println("Winning Statistics")
        println("---")
        println("3 Matches (5,000 KRW) – ${result.matchCount(3)} tickets")
        println("4 Matches (50,000 KRW) – ${result.matchCount(4)} tickets")
        println("5 Matches (1,500,000 KRW) – ${result.matchCount(5)} tickets")
        println("5 Matches + Bonus Ball (30,000,000 KRW) – ${result.matchCount(5, bonus = true)} tickets")
        println("6 Matches (2,000,000,000 KRW) – ${result.matchCount(6)} tickets")
        println(String.format(Locale.US, "Total return rate is %.1f%%.", result.getProfitRate()))
    }
}
