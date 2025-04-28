package lotto.domain

enum class MatchLotto(val count: Int, val reward: Int, val description: String) {
    FIRST(6, 2_000_000_000, "6 Matches"),
    SECOND(5, 30_000_000, "5 Matches + Bonus Ball"),
    THIRD(5, 1_500_000, "5 Matches"),
    FOURTH(4, 50_000, "4 Matches"),
    FIFTH(3, 5_000, "3 Matches"),
    NONE(0, 0, "");

    companion object {
        fun from(matched: Int, bonusMatched: Boolean): MatchLotto {
            return when {
                matched == 6 -> FIRST
                matched == 5 && bonusMatched -> SECOND
                matched == 5 -> THIRD
                matched == 4 -> FOURTH
                matched == 3 -> FIFTH
                else -> NONE
            }
        }
    }
}
