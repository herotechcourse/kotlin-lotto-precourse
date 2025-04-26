package lotto.domain

fun determineRank(matchCount: Int, bonusMatched: Boolean): Rank {
    if (matchCount == 6)
        return Rank.FIRST
    else if (matchCount == 5 && bonusMatched)
        return Rank.SECOND
    else if (matchCount == 5 && !bonusMatched)
        return Rank.THIRD
    else if (matchCount == 4)
        return Rank.FOURTH
    else if (matchCount == 3)
        return Rank.FIFTH
    else
        return Rank.MISS
}