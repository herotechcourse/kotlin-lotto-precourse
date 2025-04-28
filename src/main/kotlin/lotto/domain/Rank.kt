package lotto.domain

enum class Rank(val matches: Int, val bonusRequired: Boolean, val prize: Long) {
    FIRST(6, false, 2_000_000_000L),
    SECOND(5, true, 30_000_000L),
    THIRD(5, false, 1_500_000L),
    FOURTH(4, false, 50_000L),
    FIFTH(3, false, 5_000L),
    NONE(0, false, 0L);

    companion object {
        fun of(
            ticket: List<Int>,
            winning: List<Int>,
            bonus: Int
        ): Rank {
            val matchCount = ticket.count { it in winning }
            val bonusHit = bonus in ticket
            return values().firstOrNull {
                it.matches == matchCount && it.bonusRequired == bonusHit
            } ?: NONE
        }
    }
}
