package lotto.domain

class LottoResult(val statistics: Map<PrizeCategory, Int>) {

    fun totalWinnings(): Int {
        return statistics.entries.sumOf { (prizeCategory, count) -> prizeCategory.prizeAmount * count }
    }
}
