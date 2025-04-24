package lotto.model

enum class Rank(val winningMoney: Int, val countOfMatch: Int) {
    FIRST(2_000_000_000, 6),
    SECOND(30_000_000, 5),
    THIRD(1_500_000, 5),
    FOURTH(50_000, 4),
    FIFTH(5_000, 3);
}
