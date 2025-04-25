package lotto

enum class Rank(val matchCount: Int, val prize: Int, val matchText: String) {
    FIRST(6, 2_000_000_000, "6 numbers matched (Jackpot)"),
    SECOND(5, 30_000_000, "5 + Bonus matched"),
    THIRD(5, 1_500_000, "5 numbers matched"),
    FOURTH(4, 50_000, "4 numbers matched"),
    FIFTH(3, 5_000, "3 numbers matched"),
    NONE(0, 0, "No prize");

    companion object {
        fun from(count: Int, matchBonus: Boolean): Rank {
            return when (count) {
                6 -> FIRST
                5 -> if (matchBonus) SECOND else THIRD
                4 -> FOURTH
                3 -> FIFTH
                else -> NONE
            }
        }
    }
}
