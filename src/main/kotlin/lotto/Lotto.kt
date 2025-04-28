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
enum class Rank(val matchCount: Int, val matchBonus: Boolean, val prize: Int, val rank: Int) {
    FIRST(6, false, 2_000_000_000, 1),
    SECOND(5, true, 30_000_000, 2),
    THIRD(5, false, 1_500_000, 3),
    FOURTH(4, false, 50_000, 4),
    FIFTH(3, false, 5_000, 5),
    NONE(0, false, 0, 6);

    companion object {
        fun of(count: Int, bonus: Boolean): Rank {
            return when {
                count == 6 -> FIRST
                count == 5 && bonus -> SECOND
                count == 5 -> THIRD
                count == 4 -> FOURTH
                count == 3 -> FIFTH
                else -> NONE
            }
        }
    }

    fun message(count: Int): String {
        return when (this) {
            SECOND -> "5 Matches + Bonus Ball (${prize} KRW) – $count tickets"
            else -> "${matchCount} Matches (${prize} KRW) – $count tickets"
        }
    }
}
