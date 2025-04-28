package lotto.view

import lotto.enums.LottoRank

class LottoOutputView {
    fun printLottoCount(lottoCount: Int) {
        println(BUY_COUNT_MESSAGE + lottoCount + BUY_TICKETS)
    }

    fun printLottoTicket(lottoTicketNumbers: List<List<Int?>>) {
        lottoTicketNumbers.stream()
            .map { lotto: List<Int?> -> lotto.toString() }  // 각 로또 티켓 번호를 문자열로 변환
            .forEach { x: String? -> println(x) }  // 각 로또 티켓 번호를 한 줄씩 출력
        println()
    }

    fun printLottoResult(rankResults: Map<LottoRank, Int>, totalEarnings: Double) {
        printResultMessage()
        printRankResult(rankResults)
        printEarningRate(totalEarnings)
    }

    private fun printEarningRate(totalEarnings: Double) {
        println(EARNING_RATE_MESSAGE + totalEarnings + EARNING_RATE_PERCENT_MESSAGE)
    }

    private fun printRankResult(rankResults: Map<LottoRank, Int>) {
        for (rank in LottoRank.entries) {
            val result = StringBuilder()
            result.append(rank.matchCount).append(EQUAL_COUNT)
            if (rank == LottoRank.SECOND) {
                result.append(BONUS_BALL_MESSAGE)
            }
            System.out.printf(result.toString())
            System.out.printf(MATCH_NUMBER_COUNT, rank.prize, rankResults[rank])
            println()
        }
    }

    private fun printResultMessage() {
        println(WINNING_STATISTICS)
        println(LINE)
    }

    fun printExceptionMessage(exception: IllegalArgumentException) {
        println(ERR_MESSAGE + exception.message)
    }

    companion object {
        private const val ERR_MESSAGE = "[ERROR] "

        private const val WINNING_STATISTICS = "Winning Statistics"

        private const val LINE = "-----------------"

        private const val BUY_COUNT_MESSAGE = "You have purchased "
        private const val BUY_TICKETS = " tickets."

        private const val EARNING_RATE_MESSAGE = "Total return rate is "

        private const val EARNING_RATE_PERCENT_MESSAGE = "%."

        private const val EQUAL_COUNT = " Matches"

        private const val BONUS_BALL_MESSAGE = " + Bonus Ball"

        private const val MATCH_NUMBER_COUNT = " (%,d KRW) – %d tickets"
    }
}
