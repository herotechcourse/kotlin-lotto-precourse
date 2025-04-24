package lotto

enum class Rank(val rank: Int, val matchCount: Int, val isBonusNumberRequired: Boolean, val price: Int) {
    FIRST_PRIZE(1, 6, false, 2000000000),
    SECOND_PRIZE(2, 5, true, 30000000),
    THIRD_PRIZE(3, 4,false,  1500000),
    FOURTH_PRIZE(4, 4,false, 50000),
    FIFTH_PRIZE(5, 3, false, 5000)
}