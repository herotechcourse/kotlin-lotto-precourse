package lotto

data class LottoResult(
    val ticket: Lotto,
    val matchCount: Int,
    val bonusMatched: Boolean,
    val prize: Prize
)
