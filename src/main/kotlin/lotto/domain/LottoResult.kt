package lotto.domain

enum class LottoResult(val matchCount: Int, val prize: Long) {
    NONE(0, 0),
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000),
    FIRST(6, 2_000_000_000);

    companion object {
        fun of(ticket: LottoTicket, winning: Set<Int>, bonus: Int): LottoResult {
            val count = ticket.numbers.count { it in winning }
            return when {
                count == 6 -> FIRST
                count == 5 && ticket.numbers.contains(bonus) -> SECOND
                count == 5 -> THIRD
                count == 4 -> FOURTH
                count == 3 -> FIFTH
                else       -> NONE
            }
        }
    }
}
