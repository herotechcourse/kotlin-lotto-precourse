package lotto.domain

enum class Prize(
    val matchCount: Int,
    val matchBonus: Boolean,
    val amount: Int,
    val description: String
) {
    FIRST(6, false, 2_000_000_000, "6 Matches"),
    SECOND(5, true, 30_000_000, "5 Matches + Bonus Number"),
    THIRD(5, false, 1_500_000, "5 Matches"),
    FOURTH(4, false, 50_000, "4 Matches"),
    FIFTH(3, false, 5_000, "3 Matches"),
    NONE(0, false, 0, "No Prize");
    
    companion object {
        fun getByMatchResult(matchCount: Int, hasBonus: Boolean): Prize {
            return values().find { 
                it.matchCount == matchCount && it.matchBonus == hasBonus 
            } ?: NONE
        }
    }
} 