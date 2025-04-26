package lotto

enum class Rank(val matchCount: Int, val prize: Int, val bonusBall: Boolean? = null) {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000, true),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    NONE(0, 0);

    companion object {
        fun find(count: Int, bonus: Boolean): Rank {
            return when {
                count == 6 -> FIRST
                count == 5 && bonus -> SECOND
                count == 5 -> THIRD
                count == 4 -> FOURTH
                count == 3 -> FIFTH
                else -> NONE
            }
        }
    }
}
