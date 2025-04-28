package lotto.domain

enum class TicketPrice(val value: Int) {
    TICKET(1000)
}

enum class Rank(val matchCount: Int, val prize: Int, val matchBonus: Boolean = false) {
    THREE(3, 5_000),
    FOUR(4, 50_000),
    FIVE(5, 1_500_000),
    FIVE_BONUS(5, 30_000_000, true),
    SIX(6, 2_000_000_000);

    companion object {
        fun from(count: Int, bonusMatch: Boolean): Rank? {
            return when {
                count == 6 -> SIX
                count == 5 && bonusMatch -> FIVE_BONUS
                count == 5 -> FIVE
                count == 4 -> FOUR
                count == 3 -> THREE
                else -> null
            }
        }
    }
}