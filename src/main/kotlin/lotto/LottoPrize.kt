package lotto

enum class LottoPrize(
    private val matches: String,
    val prizeAmount: Int,
    val value: Int,
) {

    THREE_MATCHES("3 Matches", 5_000, 3),
    FOUR_MATCHES("4 Matches", 50_000, 4),
    FIVE_MATCHES("5 Matches", 1_500_000, 5),
    FIVE_MATCHES_BONUS("5 Matches + Bonus Ball", 30_000_000, 5),
    SIX_MATCHES("6 Matches", 2_000_000_000, 6);

    var ticketCount = 0
        private set

    fun updateTicketCount() {
        ticketCount += 1
    }
}
