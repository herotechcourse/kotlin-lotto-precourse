package lotto

import camp.nextstep.edu.missionutils.Randoms

object LottoService {

    fun generateTickets(count: Int): List<Lotto> {
        return List(count, fun(_: Int): Lotto{
            return Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6))
        })
    }

    fun calculateLottoResult(tickets: List<Lotto>, winningNumbers: List<Int>, bonus: Int): Map<Rank, Int> {
        val resultMap = mutableMapOf<Rank, Int>()

        for (ticket in tickets) {
            val matchCount = ticket.getNumbers().count { it in winningNumbers }
            val bonusMatch = ticket.getNumbers().contains(bonus)

            val rank = when {
                matchCount == 6 -> Rank.FIRST
                matchCount == 5 && bonusMatch -> Rank.SECOND
                matchCount == 5 -> Rank.THIRD
                matchCount == 4 -> Rank.FOURTH
                matchCount == 3 -> Rank.FIFTH
                else -> Rank.NONE
            }

            resultMap[rank] = resultMap.getOrDefault(rank, 0) + 1
        }
        for (rank in Rank.values()) {
            resultMap.putIfAbsent(rank, 0)
        }
        return resultMap
    }


}



enum class Rank(val matchCount: Int, val bonus: Boolean, val prize: Int, val message: String) {
    FIRST(6, false, 2_000_000_000, "6 Matches (2,000,000,000 KRW)"),
    SECOND(5, true, 30_000_000, "5 Matches + Bonus Ball (30,000,000 KRW)"),
    THIRD(5, false, 1_500_000, "5 Matches (1,500,000 KRW)"),
    FOURTH(4, false, 50_000, "4 Matches (50,000 KRW)"),
    FIFTH(3, false, 5_000, "3 Matches (5,000 KRW)"),
    NONE(0, false, 0, "No Prize");
}



