package lotto

enum class LottoTicketCategory(val prize: Long, val message: String) {
    MATCH_0(0, ""),
    MATCH_3(5000, "3 Matches (5,000 KRW)"),
    MATCH_4(50000, "4 Matches (50,000 KRW)"),
    MATCH_5(1500000, "5 Matches (1,500,000 KRW)"),
    MATCH_5_BONUS(30000000, "5 Matches + Bonus Ball (30,000,000 KRW)"),
    MATCH_6(2000000000, "6 Matches (2,000,000,000 KRW)");

    companion object {
        fun fromMatchCount(matchCount: Int, hasBonus: Boolean): LottoTicketCategory {
            return when (matchCount) {
                6 -> MATCH_6
                5 -> if (hasBonus) MATCH_5_BONUS else MATCH_5
                4 -> MATCH_4
                3 -> MATCH_3
                else -> MATCH_0
            }
        }
    }
}
