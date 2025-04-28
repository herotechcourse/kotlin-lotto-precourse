package lotto.domain

import java.text.NumberFormat
import java.util.Locale

enum class Rank (
    val matchCount: Int,
    val matchBonus: Boolean,
    val prize: Int
) {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    NONE(0, false, 0);

    fun isWinning(): Boolean = this != NONE

    fun description(ticketCount: Int): String =
        "${matchCount} Matches${if (this == SECOND) " + Bonus Ball" else ""} (${formatPrize()}) – ${ticketCount} tickets"

    private fun formatPrize(): String =
        NumberFormat.getInstance(Locale.US).format(prize) + " KRW"

    companion object {
        fun from (matchCount: Int, matchBonus: Boolean): Rank = when {
            matchCount == 6 -> FIRST
            matchCount == 5 && matchBonus -> SECOND
            matchCount == 5 -> THIRD
            matchCount == 4 -> FOURTH
            matchCount == 3 -> FIFTH
            else -> NONE
        }
    }
}
