package lotto.domain

enum class Prize(
    val matchCount: Int,
    val matchBonus: Boolean,
    val amount: Int,
    val description: String
) {
    FIRST(6, false, 2_000_000_000, PrizeDescription.FIRST),
    SECOND(5, true, 30_000_000, PrizeDescription.SECOND),
    THIRD(5, false, 1_500_000, PrizeDescription.THIRD),
    FOURTH(4, false, 50_000, PrizeDescription.FOURTH),
    FIFTH(3, false, 5_000, PrizeDescription.FIFTH),
    NONE(0, false, 0, PrizeDescription.NONE);

    companion object {
        fun valuesForResult(): List<Prize> =
            listOf(FIFTH, FOURTH, THIRD, SECOND, FIRST)
    }
}

object PrizeDescription {
    const val FIRST = "6 Matches (2,000,000,000 KRW)"
    const val SECOND = "5 Matches + Bonus Ball (30,000,000 KRW)"
    const val THIRD = "5 Matches (1,500,000 KRW)"
    const val FOURTH = "4 Matches (50,000 KRW)"
    const val FIFTH = "3 Matches (5,000 KRW)"
    const val NONE = "No Prize"
}
