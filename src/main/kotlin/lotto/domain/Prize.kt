package lotto.domain

enum class Prize(
    val matchCount: Int,
    val matchBonus: Boolean,
    val amount: Int,
    val description: String
) {
    FIRST(6, false, 2_000_000_000, "6 Matches (2,000,000,000 KRW)"),
    SECOND(5, true, 30_000_000, "5 Matches + Bonus Ball (30,000,000 KRW)"),
    THIRD(5, false, 1_500_000, "5 Matches (1,500,000 KRW)"),
    FOURTH(4, false, 50_000, "4 Matches (50,000 KRW)"),
    FIFTH(3, false, 5_000, "3 Matches (5,000 KRW)"),
    NONE(0, false, 0, "No Prize");

    companion object {
        fun valuesForResult(): List<Prize> =
            listOf(FIFTH, FOURTH, THIRD, SECOND, FIRST)
    }
}
