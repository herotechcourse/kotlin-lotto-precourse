package lotto.domain

enum class WinningPrizeRanks(val criteria: Int, val prize: Int, val hasBonus: Boolean = false) {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000, true),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    NONE(0, 0)
}
