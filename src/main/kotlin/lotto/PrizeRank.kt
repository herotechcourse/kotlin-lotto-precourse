package lotto

enum class PrizeRank(val matches: Int, val bonusNumber: Int, val prize: String, val amount: Int) {
    FIFTH(3, 0, "5,000 KRW", 5_000),
    FOURTH(4, 0, "50,000 KRW", 50_000),
    THIRD(5, 0, "1,500,000 KRW", 1_500_000),
    SECOND(5, 1, "30,000,000 KRW", 30_000_000),
    FIRST(6, 0, "2,000,000,000 KRW", 2_000_000_000)
}