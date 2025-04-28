package lotto

object OutputView {
    fun printLottos(lottos: List<Lotto>) {
        println("\nYou have purchased ${lottos.size} tickets.")
        for (lotto in lottos) {
            println(lotto.toString())
        }
    }

    fun printResult(result: Map<Rank, Int>) {
        println("\nLotto result statistics")
        println("---")
        Rank.entries
            .filter { it != Rank.NONE }
            .sortedByDescending { it.matchCount }
            .forEach { rank ->
                println("${rank.matchCount} Matches${if (rank.matchBonus) " + Bonus" else ""} (${rank.prizeAmount} KRW) - ${result.getOrDefault(rank, 0)} tickets")
            }
    }

    fun printProfitRate(profitRate: Double) {
        println("Total return rate is %.1f%%".format(profitRate))
    }
}