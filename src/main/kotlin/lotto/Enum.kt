package lotto

enum class Prize(val money: Int, val numberOfMatches: Int, val hasBonus: Boolean) {
    Fifth(5_000, 3, false),
    Fourth(50_000, 4, false),
    Third(1_500_000, 5, false),
    Second(30_000_000, 5, true),
    First(2_000_000_000, 6, false),
    None(0, 0, false)
}
