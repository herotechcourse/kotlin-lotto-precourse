package lotto.model

enum class LottoRank(
    val matchCount: Int,
    val matchBonus: Boolean,
    val prize: Int
) {
    FIRST(6, false, 2000000000),
    SECOND(5, true, 30000000),
    THIRD(5, false, 1500000),
    FOURTH(4, false, 50000),
    FIFTH(3, false, 5000),
    NOTHING(0, false, 0);

    companion object {
        fun of(matchCount: Int, matchBonus: Boolean): LottoRank {
            return when {
                matchCount == 6 -> FIRST
                matchCount == 5 && matchBonus -> SECOND
                matchCount == 5 -> THIRD
                matchCount == 4 -> FOURTH
                matchCount == 3 -> FIFTH
                else -> NOTHING
            }
        }
    }
}
