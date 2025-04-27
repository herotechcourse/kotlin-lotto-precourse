package lotto

enum class Rank(val matchedCount: Int, val prizeMoney: Int, val bonus: Boolean = false) {
    FIRST(6, Configuration.Prices.FIRST),
    SECOND(5, Configuration.Prices.SECOND),
    THIRD(5, Configuration.Prices.THIRD,true),
    FOURTH(4, Configuration.Prices.FOURTH),
    FIFTH(3, Configuration.Prices.FIFTH);

    fun getPrizeMoneyInKRW(): String {
        return "${String.format("%,d", prizeMoney).replace('.', ',')} KRW"
    }
}