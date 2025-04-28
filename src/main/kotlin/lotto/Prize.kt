package lotto

enum class Prize(val matchCount: Int, val hasBonus: Boolean, val prizeAmount: Long) {
    FIRST(6,false,2_000_000_000),
    SECOND(5,true,30_000_000),
    THIRD(5,false,1_500_000),
    FOURTH(4,false,50_000),
    FIFTH(3,false,5_000),
    NONE(0,false,0);

    companion object {
        fun getRank(matchCount: Int, hasBonusMatch: Boolean): Prize = when {
            matchCount == 6 -> FIRST
            matchCount == 5 && hasBonusMatch -> SECOND
            matchCount == 5 -> THIRD
            matchCount == 4 -> FOURTH
            matchCount == 3 -> FIFTH
            else -> NONE

        }
    }
}