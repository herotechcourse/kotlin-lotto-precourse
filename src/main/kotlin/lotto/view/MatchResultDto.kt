package lotto.view

import lotto.enums.Rank

data class MatchResultDto(val output: String) {

    companion object {
        fun getMatchResultDto(matchResult: Map<Rank, Int>): MatchResultDto {
            val matchResultForOutput = matchResult
                .filter { it.key != Rank.NONE }
                .entries
                .sortedByDescending { it.key.rank }
                .joinToString(separator = "\n") { it.key.matchCount.first.toString() + " Matches (" + it.key.price.toString() + " KRW) - " + it.value.toString() + " tickets" }
            return MatchResultDto(matchResultForOutput)
        }
    }
}
