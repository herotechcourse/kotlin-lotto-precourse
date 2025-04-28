package lotto.domain

enum class Rank(val matches: Int, val bonusMatch: Boolean, val prize: Long) {
    FIRST(6, false, 2_000_000_000L),
    SECOND(5, true, 30_000_000L),
    THIRD(5, false, 1_500_000L),
    FOURTH(4, false, 50_000L),    // ← 50 KRW가 아니라 '50,000 KRW' 원액을 설정
    FIFTH(3, false, 5_000L),
    NONE(0, false, 0L);

    companion object {
        fun of(
            ticketNumbers: List<Int>,
            winningNumbers: List<Int>,
            bonusNumber: Int
        ): Rank {
            val matchCount = ticketNumbers.count { it in winningNumbers }
            val bonusHit = bonusNumber in ticketNumbers
            return values().firstOrNull {
                it.matches == matchCount && it.bonusMatch == bonusHit
            } ?: NONE
        }
    }
}
