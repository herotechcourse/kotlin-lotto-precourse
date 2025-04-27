package lotto

fun main() {
    val inputReader = InputReader()
    val outputWriter = OutputWriter()

    val order = inputReader.readPurchaseOrder()
    val tickets = LottoGenerator.run(order.getLottoCount())
    outputWriter.printTickets(tickets)

    val winningNumbers = inputReader.readWinningNumbers()
    val bonusNumber = inputReader.readBonusNumber()

    val statistics = WinningStatisticsCalulator.run(tickets, winningNumbers, bonusNumber)

    outputWriter.printWinningStatistics(statistics)
    outputWriter.printTotalReturnRate(statistics, order.getPurchaseAmount())
}