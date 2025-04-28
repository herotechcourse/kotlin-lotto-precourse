package lotto

object OutputView {
    fun printLottos(lottos: List<Lotto>) {
        println()
        println("You have purchased ${lottos.size} tickets.")
        for (lotto in lottos) {
            println(lotto.toString())
        }
    }

    fun printResult(result: Map<Rank, Int>) {
        println()
        println("Winning Statistics")
        println("---")
        Rank.entries
            .filter { it != Rank.NONE }
            .sortedBy { it.matchCount }
            .forEach { rank ->
                println(
                    "${rank.matchCount} Matches${if (rank.matchBonus) " + Bonus Ball" else ""} (${rank.prizeAmount.formatWithComma()} KRW) – ${
                        result.getOrDefault(
                            rank,
                            0
                        )
                    } tickets"
                )
            }
    }

    fun printProfitRate(profitRate: Double) {
        println("Total return rate is ${"%.1f".format(profitRate)}%.")
    }

    private fun Int.formatWithComma(): String {
        return String.format("%,d", this)
    }

}