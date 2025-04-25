package lotto.domain

object RankDecider {
    fun decide(result: LottoMatchResult): Prize {
        if (result.matchCount == 6) return Prize.FIRST
        if (result.matchCount == 5 && result.bonusMatched) return Prize.SECOND
        if (result.matchCount == 5) return Prize.THIRD
        if (result.matchCount == 4) return Prize.FOURTH
        if (result.matchCount == 3) return Prize.FIFTH
        return Prize.NONE
    }
}
