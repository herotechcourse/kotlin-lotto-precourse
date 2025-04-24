package lotto

object LottoResult {
    fun calculate(tickets: List<Lotto>, winningLotto: WinningLotto): Map<Rank, Int> {
        return tickets.map { winningLotto.rankOf(it) }
            .groupingBy { it }
            .eachCount()
    }
}
