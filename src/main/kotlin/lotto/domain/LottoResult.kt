package lotto.domain

enum class LottoResult(
    val rank: Int,
    val matchingCount: Int,
    val winningAmount: Int,
    val doesBonusNumberMatch: List<Boolean>
) {
    FIFTH_PLACE(5, 3, 5_000, listOf(true, false)),
    FOURTH_PLACE(4, 4, 50_000, listOf(true, false)),
    THIRD_PLACE(3, 5, 1_500_000, listOf(false)),
    SECOND_PLACE(2, 5, 30_000_000, listOf(true)),
    FIRST_PLACE(1, 6, 2_000_000_000, listOf(true, false));

    companion object {
        fun getLottoResult(matchingCount: Int, doesBonusNumberMatch: Boolean): LottoResult? {
            return entries.find {
                it.matchingCount == matchingCount && it.doesBonusNumberMatch.contains(doesBonusNumberMatch)
            }
        }
    }
}