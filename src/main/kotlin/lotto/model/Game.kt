package lotto.model

import lotto.Lotto
import lotto.enums.Rank
import java.util.*

class Game(private val purchaseAmount: Int, private val lottoTicket: List<Lotto>, private val winningLotto: WinningLotto) {

    private val matchResult: MutableMap<Rank, Int> = EnumMap(Rank::class.java)

    fun match(): Map<Rank, Int>  {
        for(rank: Rank in Rank.entries) {
            matchResult[rank] = 0
        }
        lottoTicket.forEach {lotto ->
            val (matchCount, bonusNumberMatched) = countMatchesWithBonus(lotto, winningLotto)
            val rank = Rank.getRank(matchCount, bonusNumberMatched)
            matchResult.merge(rank, 1, Int::plus)
        }
        return matchResult.toMap()
    }

    fun countReturnRate() : Double {
        var profit = 0
        matchResult.forEach { (rank, count) ->
            profit += rank.price * count
        }
        return profit / purchaseAmount.toDouble()
    }

    private fun countMatchesWithBonus(lotto: Lotto, winningLotto: WinningLotto): Pair<Int, Boolean> {
        val matchCount = lotto.getNumbers().intersect(winningLotto.winningLotto.getNumbers().toSet()).size
        val bonusNumber = winningLotto.bonusNumber in lotto.getNumbers()
        return matchCount to bonusNumber
    }
}
