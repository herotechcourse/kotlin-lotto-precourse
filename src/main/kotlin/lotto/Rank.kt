package lotto

enum class Rank(
    val matchCount: Int,
    val requireBonus: Boolean,
    val prize: Long
) {
    FIRST( Config.RankConfig.FIRST_MATCH_COUNT,  false, Config.RankConfig.FIRST_PRIZE),
    SECOND(Config.RankConfig.SECOND_MATCH_COUNT, true,  Config.RankConfig.SECOND_PRIZE),
    THIRD( Config.RankConfig.THIRD_MATCH_COUNT,  false, Config.RankConfig.THIRD_PRIZE),
    FOURTH(Config.RankConfig.FOURTH_MATCH_COUNT, false, Config.RankConfig.FOURTH_PRIZE),
    FIFTH( Config.RankConfig.FIFTH_MATCH_COUNT,  false, Config.RankConfig.FIFTH_PRIZE),
    NONE(  0,                                 false,                0L);

    companion object {
        fun of(matchCount: Int, bonusMatched: Boolean): Rank =
            Rank.entries.firstOrNull {
                it.matchCount == matchCount && (!it.requireBonus || bonusMatched)
            } ?: NONE
    }
}
