package lotto

object OutputView {
    fun myLotto(myLotto: List<Lotto>) {
        println("\nYou have purchased ${myLotto.size} tickets.")
        myLotto.forEach { lotto ->
            println(lotto.getNumbers())
        }
    }

    fun resultStatistics() {
        val rankStatistics = TicketChecker.getStatistics()

        println(
            "\nWinning Statistics\n" +
                    "---\n" +
                    "3 Matches (5,000 KRW) – ${rankStatistics[Rank.THREE]} tickets\n" +
                    "4 Matches (50,000 KRW) – ${rankStatistics[Rank.FOUR]} tickets\n" +
                    "5 Matches (1,500,000 KRW) – ${rankStatistics[Rank.FIVE]} tickets\n" +
                    "5 Matches + Bonus Ball (30,000,000 KRW) – ${rankStatistics[Rank.FIVE_BONUS]} tickets\n" +
                    "6 Matches (2,000,000,000 KRW) – ${rankStatistics[Rank.SIX]} tickets"
        )
    }

    fun profitRate(profitRate: Double) {
        println("Total return rate is ${profitRate}%.")
    }
}