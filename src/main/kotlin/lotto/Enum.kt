package lotto

enum class Prize(val prizeMoney: Int, val numberOfMatches: Int, val bonus: Boolean) {
    FifthPrize(5_000, 3, false),
    FourthPrize(50_000, 4, false),
    ThirdPrize(1_500_000, 5, false),
    SecondPrize(30_000_000, 5, true),
    FirstPrize(2_000_000_000, 6, false),
    None(0, 0, false)
}
