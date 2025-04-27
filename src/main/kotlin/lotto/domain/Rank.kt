package lotto.domain

enum class Rank(val matchCount: Int, val prize: Int, val needsBonus: Boolean = false) {
	FIRST(6, 2_000_000_000),
	SECOND(5, 30_000_000, needsBonus = true),
	THIRD(5, 1_500_000),
	FOURTH(4, 50_000),
	FIFTH(3, 5_000),
	NONE(0, 0);

	companion object {
		fun from(matchedCount: Int, bonusMatched: Boolean): Rank {
			return when {
				matchedCount == 6 -> FIRST
				matchedCount == 5 && bonusMatched -> SECOND
				matchedCount == 5 -> THIRD
				matchedCount == 4 -> FOURTH
				matchedCount == 3 -> FIFTH
				else -> NONE
			}
		}
	}
}