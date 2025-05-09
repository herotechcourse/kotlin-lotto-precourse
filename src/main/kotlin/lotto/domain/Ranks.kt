package lotto.domain

class Ranks {
    val size: Int
        get() = ranks.size
    private val ranks: List<Rank> = Rank.entries.sortedBy { it.matchCount }

    fun getOrNull(matchCount: Int, bonusBallMatched: Boolean): Rank? {
        return ranks.firstOrNull { it.matchCount == matchCount && (!it.bonusBallRequired || bonusBallMatched) }
    }

    fun sortedByPrize(): List<Rank> {
        return ranks.sortedBy { it.prize }
    }

    fun toList(): List<Rank> {
        return ranks.toList()
    }

    operator fun get(i: Int): Rank {
        return ranks[i]
    }

    fun createCounter(): MutableMap<Rank, Int> {
        return ranks.associateWith { 0 }.toMutableMap()
    }
}
