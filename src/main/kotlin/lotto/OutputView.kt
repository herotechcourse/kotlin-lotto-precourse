package lotto

object OutputView {
    fun printPurchaseCount(count: Int) {
        println("You have purchased $count tickets.")
    }

    fun printLottoNumbers(lottos: List<Lotto>) {
        lottos.forEach { lotto ->
            println(lotto.getNumbers())
        }
    }

    fun printResult(lottoResult: LottoResult) {
        println("Winning Statistics")
        println("---")
        Rank.entries
            .filter { it != Rank.NONE }
            .sortedBy { it.prize }
            .reversed()
            .forEach { rank ->
                println("${rank.matchCount} Matches${if (rank.hasBonus) " + Bonus Ball" else ""} (${rank.prize} KRW) – ${lottoResult.getMatchCounts()[rank] ?: 0} tickets")
            }
    }

    fun printProfitRate(profitRate: Double) {
        println("Total return rate is ${String.format("%.1f", profitRate)}%.")
    }
}