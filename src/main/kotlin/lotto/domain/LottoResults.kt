package lotto.domain

class LottoResults(results: List<LottoMatchResult>) {
    private val statistics: Map<Prize, Int> = results
        .map(RankDecider::decide)
        .groupingBy { it }
        .eachCount()
        .withDefault { 0 }

    fun countOf(prize: Prize): Int = statistics.getValue(prize)

    fun toResultLines(): List<LottoResultLine> =
        Prize.valuesForResult().map { prize ->
            LottoResultLine(prize.description, countOf(prize))
        }
}
