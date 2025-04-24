package lotto

object OutputView {
    private const val PROMPT_PURCHASE_AMOUNT = "Please enter the purchase amount."
    private const val PROMPT_WINNING_NUMBERS = "Please enter last week's winning numbers."
    private const val PROMPT_BONUS_NUMBER = "Please enter the bonus number."
    private const val WINNING_STATISTICS = "Winning Statistics"
    private const val SEPARATOR = "---"
    private const val TICKETS_PURCHASED = "You have purchased %d tickets."
    private const val RETURN_RATE = "Total return rate is %,.1f%%."


    fun printPurchaseAmount() {
        println(PROMPT_PURCHASE_AMOUNT)
    }

    fun printWinningNumbers() {
        printBlankLine()
        println(PROMPT_WINNING_NUMBERS)
    }

    fun printBonusNumber() {
        printBlankLine()
        println(PROMPT_BONUS_NUMBER)
    }

    fun printTicketCount(count: Int) {
        printBlankLine()
        println(String.format(TICKETS_PURCHASED, count))
    }

    fun printTickets(ticketNumbers: List<List<Int>>) {
        ticketNumbers.forEach { ticket ->
            println(ticket.sorted().toString())
        }
    }

    fun printResultStatistics(statistics: Map<LottoRank, Int>) {
        printBlankLine()
        println(WINNING_STATISTICS)
        println(SEPARATOR)
        LottoRank.entries
            .filter { it != LottoRank.MISS }
            .forEach { rank -> printLottoRankStatisticsLines(statistics, rank) }
    }

    fun printsReturnRate(rate: Double) {
        println(String.format(RETURN_RATE, rate))
    }

    private fun printLottoRankStatisticsLines(statistics: Map<LottoRank, Int>, rank: LottoRank) {
        val count = statistics[rank] ?: 0
        println("${rank.description} - $count tickets.")
    }

    private fun printBlankLine() {
        println()
    }
}