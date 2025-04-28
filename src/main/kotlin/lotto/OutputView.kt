package lotto

object OutputView {
    fun printLine() {
        print(Constants.LINE_SEPARATOR)
    }

    fun printPurchasedTickets(ticketAmount: Int) {
        println(Constants.PURCHASED_TICKETS.format(ticketAmount))
    }

    fun printLottoList(lottoList: List<Lotto>) {
        lottoList.forEach { println(it) }
    }

    fun printWinningStatisticsTitle() {
        println(Constants.RESULT_WINNING_STATISTICS)
        println(Constants.RESULT_SEPARATOR)
    }

    fun printWinningResult(prizeText: String, prizeAmount: Int, count: Int) {
        println(Constants.WINNING_RESULT.format(prizeText, prizeAmount, count))
    }

    fun printReturnRate(rate: Double) {
        println(Constants.RETURN_RATE.format(rate))
    }
}