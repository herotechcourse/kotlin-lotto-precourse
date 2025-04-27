package lotto.view

import lotto.enums.Rank

data class MatchResultDto(val output: String) {

    companion object {
        fun getMatchResultDto(matchResult: Map<Rank, Int>): MatchResultDto {
            val matchResultForOutput = matchResult
                .filter { it.key != Rank.NONE }
                .entries
                .sortedByDescending { it.key.rank }
                .joinToString(separator = "\n") { entry ->
                    "${entry.key.matchCount.first} Matches " +
                            (if (entry.key.isBonusNumberRequired) "+ Bonus Ball " else "") +
                            "(${String.format("%,d", entry.key.price)} KRW) - ${entry.value} tickets"
                }
            return MatchResultDto(matchResultForOutput)
        }
    }
}
