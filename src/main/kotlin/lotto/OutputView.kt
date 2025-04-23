package lotto

class OutputView {
    fun printLottoTickets(tickets: List<Lotto>) {
        println("\n${tickets.size}개를 구매했습니다.")
        tickets.forEach { println(it) }
    }

    fun printWinningStatistics(statistics: Map<Int, Int>) {
        println("\n당첨 통계")
        println("---")
        printWinningCount(3, "5,000원", statistics)
        printWinningCount(4, "50,000원", statistics)
        printWinningCount(5, "1,500,000원", statistics)
        printSecondPrizeCount(statistics)
        printWinningCount(6, "2,000,000,000원", statistics)
    }

    fun printProfitRate(profitRate: Double) {
        println("총 수익률은 ${String.format("%.1f", profitRate)}%입니다.")
    }

    private fun printWinningCount(matchCount: Int, prize: String, statistics: Map<Int, Int>) {
        val count = statistics[matchCount] ?: 0
        println("${matchCount}개 일치 ($prize) - ${count}개")
    }

    private fun printSecondPrizeCount(statistics: Map<Int, Int>) {
        val count = statistics[5] ?: 0
        println("5개 + 보너스 일치 (30,000,000원) - ${count}개")
    }
} 