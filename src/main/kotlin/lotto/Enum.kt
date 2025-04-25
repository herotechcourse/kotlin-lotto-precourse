package lotto

enum class Prize(val prizeMoney: Int) {
    FirstPrize(2_000_000_000),
    SecondPrize(30_000_000),
    ThirdPrize(1_500_000),
    FourthPrize(50_000),
    FifthPrize(5_000),
    None(0)
}
