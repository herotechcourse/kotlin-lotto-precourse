package lotto

object OutputView {
    fun printLottos(lottos: List<Lotto>) {
        println("You have purchased ${lottos.size} tickets.")
        lottos.forEach { println(it.getNumbers()) }
    }

    fun printResult(result: LottoResult) {
        println("Winning Statistics\n---")
        println("3 Matches (5,000 KRW) – ${result.matchCount(3)} tickets")
        println("4 Matches (50,000 KRW) – ${result.matchCount(4)} tickets")
        println("5 Matches (1,500,000 KRW) – ${result.matchCount(5)} tickets")
        println(
            "5 Matches + Bonus Ball (30,000,000 KRW) – " +
                    "${result.matchCount(5, bonus = true)} tickets"
        )
        println("6 Matches (2,000,000,000 KRW) – ${result.matchCount(6)} tickets")
        println("Total return rate is %.1f%%.".format(result.getProfitRate()))
    }
}