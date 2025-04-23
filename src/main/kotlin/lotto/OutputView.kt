package lotto

object OutputView {
    fun printTickets(tickets: List<Lotto>) {
        println("You have purchased ${tickets.size} tickets.")
        tickets.forEach {
            println(it.getNumbers())
        }
    }
    //로또 티켓 출력력

    fun printStats(result: LottoResult, rate: Double) {
        println("Winning Statistics\n---")
        Rank.values().reversed().forEach { rank ->
            val count = result.count(rank)
            if (rank != Rank.NONE) {
                println("${rank.description()} - ${count}개")
            }
        }
        println("Total return rate is ${"%.1f".format(rate)}%.")
    }
    //당첨 결과 출력력
}

