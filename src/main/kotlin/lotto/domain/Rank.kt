package lotto.domain

enum class Rank(val prizeAmount: Long, val prizeName: String) {
    FIRST(2_000_000_000, "2,000,000,000 KRW"),
    SECOND(30_000_000, "30,000,000 KRW"),
    THIRD(1_500_000, "1,500,000 KRW"),
    FOURTH(50_000, "50,000 KRW"),
    FIFTH(5_000, "5,000 KRW"),
    NONE(0, "No prize")
}
