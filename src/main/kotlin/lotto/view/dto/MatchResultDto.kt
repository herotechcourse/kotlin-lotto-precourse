package lotto.view.dto

import lotto.enums.Rank

data class MatchResultDto(val output: String) {

    companion object {
        fun getMatchResultDto(matchResult: Map<Rank, Int>): List<MatchResultDto> {
            val matchResultList: MutableList<MatchResultDto> = mutableListOf()

            matchResult.filter {it.key != Rank.NONE}
                .entries
                .sortedByDescending { it.key.rank }
                .forEach {
                        entry ->
                    matchResultList.add(
                        MatchResultDto("${entry.key.matchCount.first} Matches " +
                            (if (entry.key.isBonusNumberRequired) "+ Bonus Ball " else "") +
                            "(${String.format("%,d", entry.key.price)} KRW) – ${entry.value} tickets")
                    )
                }
            return matchResultList.toList()
        }
    }
}
