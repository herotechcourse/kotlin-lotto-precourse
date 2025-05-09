package lotto.domain

enum class Rank(val matchCount: Int, val prize: Long, val bonusBallRequired: Boolean = false) {
    FIRST(6, 2_000_000_000L),
    SECOND(5, 30_000_000L, true),
    THIRD(5, 1_500_000L),
    FOURTH(4, 50_000L),
    FIFTH(3, 5_000L);

    init {
        require(matchCount in 0..6) { " Match count must be between 0 and 6." }
        require(prize >= 0) { " Prize must be non-negative." }
    }

    override fun toString(): String {
        // "4 Matches (50,000 KRW) – 0 tickets",
//        "5 Matches + Bonus Ball (30,000,000 KRW) – 0 tickets",
        val formattedPrize = String.format("%,d", prize)
        var bonusMessage = ""
        if (bonusBallRequired)
            bonusMessage = " + Bonus Ball"

        return "$matchCount Matches$bonusMessage ($formattedPrize)"
    }
}

