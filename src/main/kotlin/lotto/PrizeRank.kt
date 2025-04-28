package lotto

enum class PrizeRank(val matches: Int, val bonusNumber: Boolean, val prize: String, val amount: Int) {
    FIFTH(3, false, "5,000 KRW", 5_000),
    FOURTH(4, false, "50,000 KRW", 50_000),
    THIRD(5, false, "1,500,000 KRW", 1_500_000),
    SECOND(5, true, "30,000,000 KRW", 30_000_000),
    FIRST(6, false, "2,000,000,000 KRW", 2_000_000_000)
}