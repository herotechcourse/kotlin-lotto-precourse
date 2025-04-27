package lotto

enum class Rank(val matchedCount: Int, val prizeMoney: Int, val bonus: Boolean = false) {
    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    THIRD(5, 30_000_000, true),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000);

    fun getPrizeMoneyInKRW(): String {
        return "${String.format("%,d", prizeMoney).replace('.', ',')} KRW"
    }
}