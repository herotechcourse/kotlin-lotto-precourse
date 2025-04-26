package lotto

// Enum class to represent prize ranks
enum class Prize(val amount: Long, val matchCount: Int, val isBonusRequired: Boolean) {
    FIRST(2_000_000_000, 6, false),
    SECOND(30_000_000, 5, true),
    THIRD(1_500_000, 5, false),
    FOURTH(50_000, 4, false),
    FIFTH(5_000, 3, false)
}