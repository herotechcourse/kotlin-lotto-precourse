package lotto

import camp.nextstep.edu.missionutils.Randoms

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] Lotto must contain exactly 6 numbers." }
        require(numbers.toSet().size == 6) { "[ERROR] Numbers must be unique." }
        require(numbers.all { it in 1..45 }) { "[ERROR] Lotto numbers must be between 1 and 45." }
    }

    val numbers: List<Int> = numbers.sorted()
}
object LottoMachine {
    fun issueTickets(amount: Int): List<Lotto> {
        val ticketCount = amount / 1000
        return List(ticketCount) {
            Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6))
        }
    }
}
class WinningLotto(private val winningNumbers: List<Int>, private val bonusNumber: Int) {
    init {
        require(winningNumbers.size == 6) { "[ERROR] Must have exactly 6 winning numbers." }
        require(winningNumbers.toSet().size == 6) { "[ERROR] Winning numbers must be unique." }
        require(winningNumbers.all { it in 1..45 }) { "[ERROR] Numbers must be between 1 and 45." }
        require(bonusNumber in 1..45) { "[ERROR] Bonus number must be between 1 and 45." }
    }

    fun matchCount(lotto: Lotto): Int = lotto.numbers.count { it in winningNumbers }
    fun matchBonus(lotto: Lotto): Boolean = bonusNumber in lotto.numbers
}
object LottoResult {
    fun calculate(lottos: List<Lotto>, winningLotto: WinningLotto): LottoResult {
        val rankCount = mutableMapOf<Rank, Int>().withDefault { 0 }

        lottos.forEach { lotto ->
            val matchCount = winningLotto.matchCount(lotto)
            val matchedBonus = winningLotto.matchBonus(lotto)
            val rank = Rank.of(matchCount, matchedBonus)
            if (rank != Rank.NONE) {
                rankCount[rank] = rankCount.getValue(rank) + 1
            }
        }

        val totalPrize = rankCount.entries.sumOf { (rank, count) -> rank.prize.toLong() * count }
        val spent = lottos.size * 1000L
        val profitRate = if (spent == 0L) 0.0 else totalPrize * 100.0 / spent

        return LottoResult(rankCount, profitRate)
    }
}

data class LottoResult(
    val rankCount: Map<Rank, Int>,
    val profitRate: Double,
)
