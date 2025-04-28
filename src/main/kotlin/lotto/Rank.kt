package lotto

enum class Rank(val matches: Int, val prize: Int, val bonus: Boolean = false) {
    THREE(3, 5000),
    FOUR(4, 50000),
    FIVE(5, 1500000),
    FIVE_BONUS(5, 30000000, true),
    SIX(6, 2000000000);

    companion object {
        fun from(rank: Int, hasBonus: Boolean): Rank? {
            return when {
                rank == 6 -> SIX
                rank == 5 && hasBonus -> FIVE_BONUS
                rank == 5 -> FIVE
                rank == 4 -> FOUR
                rank == 3 -> THREE
                else -> null
            }
        }
    }
}
