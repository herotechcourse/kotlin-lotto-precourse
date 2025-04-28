package lotto

enum class Rank(val matchCount: Int, val matchBonus: Boolean, val prize: Int, val description: String) {
    FIRST(6, false, 2_000_000_000, "6 Matches (2,000,000,000 KRW)"),
    SECOND(5, true, 30_000_000, "5 Matches + Bonus Ball (30,000,000 KRW)"),
    THIRD(5, false, 1_500_000, "5 Matches (1,500,000 KRW)"),
    FOURTH(4, false, 50_000, "4 Matches (50,000 KRW)"),
    FIFTH(3, false, 5_000, "3 Matches (5,000 KRW)");

    companion object {
        fun getByMatchCountAndBonus(matchCount: Int, matchBonus: Boolean): Rank? {
            return values().find { it.matchCount == matchCount && it.matchBonus == matchBonus }
        }
    }
} 