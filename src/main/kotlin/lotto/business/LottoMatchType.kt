package lotto.business

enum class LottoMatchType(val description: String, val price: Long) {
    THREE_MATCHES("3 Matches (5,000 KRW)", 5000),
    FOUR_MATCHES("4 Matches (50,000 KRW)", 50000),
    FIVE_MATCHES("5 Matches (1,500,000 KRW)", 1500000),
    FIVE_MATCHES_BONUS("5 Matches + Bonus Ball (30,000,000 KRW)", 30000000),
    SIX_MATCHES("6 Matches (2,000,000,000 KRW)", 2000000000)
}