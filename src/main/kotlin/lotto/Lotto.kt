package lotto

import camp.nextstep.edu.missionutils.Randoms
import kotlin.math.round


enum class LottoRank(val matchCount: Int, val hasBonus: Boolean = false, val prize: Int) {
    FIFTH(3, prize = 5000),
    FOURTH(4, prize = 50000),
    THIRD(5, prize = 1500000),
    SECOND(5, hasBonus = true, prize = 30000000),
    FIRST(6, prize = 2000000000), MISS(0, prize = 0);

    companion object {
        fun determineRank(matchCount: Int, hasBonus: Boolean): LottoRank {
            return entries.find { it.matchCount == matchCount && it.hasBonus == hasBonus }
                ?: entries.find { it.matchCount == matchCount && !it.hasBonus && !hasBonus } ?: MISS
        }
    }
}

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] Lotto must contain exactly 6 numbers." }
        require(numbers.all { it in 1..45 }) { "[ERROR] Lotto numbers must be in the range 1..45." }
        require(numbers.distinct().size == 6) { "[ERROR] Lotto numbers must be unique." }
    }

    fun matchCount(winningNumbers: List<Int>): Int = numbers.intersect(winningNumbers.toSet()).size

    fun hasBonus(bonusNumber: Int): Boolean = bonusNumber in numbers

    fun getSortedNumbers(): List<Int> = numbers.sorted()
}

class WinningLotto(private val winningNumbers: List<Int>, val bonusNumber: Int) {
    init {
        require(winningNumbers.size == 6) { "[ERROR] Winning numbers must have 6 numbers." }
        require(winningNumbers.all { it in 1..45 }) { "[ERROR] Winning numbers must be in the range 1..45." }
        require(winningNumbers.distinct().size == 6) { "[ERROR] Winning numbers must be unique." }
        require(bonusNumber in 1..45) { "[ERROR] Bonus number must be in the range 1..45." }
        require(bonusNumber !in winningNumbers) { "[ERROR] Bonus number cannot be one of the winning numbers." }
    }

    fun determineRank(lotto: Lotto): LottoRank {
        val matchCount = lotto.matchCount(winningNumbers)
        val hasBonus = lotto.hasBonus(bonusNumber)
        return LottoRank.determineRank(matchCount, hasBonus)
    }
}


class LottoGame(private val purchaseAmount: Int) {
    private val numberOfTickets = purchaseAmount / 1000
    val tickets: List<Lotto> = List(numberOfTickets) {
        Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6))
    }

    init {
        require(purchaseAmount % 1000 == 0) { "[ERROR] Purchase amount must be divisible by 1,000." }
    }

    fun getNumberOfTickets(): Int = numberOfTickets

    fun determineResults(winningLotto: WinningLotto): Map<LottoRank, Int> {
        val results = mutableMapOf<LottoRank, Int>().apply { LottoRank.entries.forEach { this[it] = 0 } }
        for (ticket in tickets) {
            val rank = winningLotto.determineRank(ticket)
            results[rank] = results.getOrDefault(rank, 0) + 1
        }
        return results
    }

    fun calculateProfitRate(results: Map<LottoRank, Int>): Double {
        val totalPrize = results.entries.sumOf { (rank, count) -> rank.prize.toLong() * count }
        return round((totalPrize.toDouble() / purchaseAmount) * 10000) / 100
    }
}