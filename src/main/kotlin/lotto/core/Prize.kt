package lotto.core

enum class Prize(
    val matches: Int,
    val winningPrize: Int,
    val hasBonus: Boolean,
    val display: String) {

    FIRST(matches = 6, winningPrize = 2_000_000_000, hasBonus = false, "6 Matches (2,000,000,000 KRW)"),
    SECOND(matches = 5, winningPrize = 30_000_000, hasBonus = true, "5 Matches + Bonus Ball (30,000,000 KRW)"),
    THIRD(matches = 5, winningPrize = 1_500_000, hasBonus = false, "5 Matches (1,500,000 KRW)"),
    FOURTH(matches = 4, winningPrize = 50_000, hasBonus = false, "4 Matches (50,000 KRW)"),
    FIFTH(matches = 3, winningPrize = 5_000, hasBonus = false, "3 Matches (5,000 KRW)"),
    NONE(matches = 0, winningPrize = 0, hasBonus = false, "")
}