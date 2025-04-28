package lotto.model

data class LottoMatchResult(
    val threeMatching: Int = 0,
    val fourMatching: Int = 0,
    val fiveMatching: Int = 0,
    val fiveMatchingWithBonus: Int = 0,
    val sixMatching: Int = 0
)
