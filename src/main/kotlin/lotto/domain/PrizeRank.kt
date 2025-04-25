package lotto.domain

enum class PrizeRank(
    val matchCnt: Int,
    val prize: Int,
    val matchBonus: Boolean = false
) {
    FIFTH(3, 5000),
    FOURTH(4, 50000),
    THIRD(5, 1500000),
    SECOND(5, 30000000, true),
    FIRST(6, 2000000000)

    companion object {
        fun from(matchCnt: Int, hasBonus: Boolean): PrizeRank? {
            return when (matchCnt) {
                6 -> FIRST
                5 -> if (hasBonus) SECOND else THIRD
                4 -> FOURTH
                3 -> THIRD
                else -> null
            }
        }
    }
}