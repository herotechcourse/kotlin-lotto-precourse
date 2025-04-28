package lotto

enum class Rank(val matchCount: Int, val reward: Int, val matchBonus: Boolean = false) {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000, true),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    companion object {
        fun from(matchCount: Int, matchBonus: Boolean): Rank {
            return when {
                matchCount == 6 -> FIRST       // matchCount가 6이면 무조건 Rank.FIRST 반환
                matchCount == 5 && matchBonus -> SECOND   // 5개 맞고 보너스 번호 일치하면 Rank.SECOND
                matchCount == 5 -> THIRD
                matchCount == 4 -> FOURTH
                matchCount == 3 -> FIFTH
                else -> MISS
            }
        }
    }

}
