package lotto

import camp.nextstep.edu.missionutils.Randoms

fun main() {
    val inputReader = InputReader()
    val outputWriter = OutputWriter()

    val order = inputReader.readPurchaseOrder()
    val tickets = generateTickets(order.getLottoCount())
    outputWriter.printTickets(tickets)

    val winningNumbers = inputReader.readWinningNumbers()
    val bonusNumber = inputReader.readBonusNumber()

    val statistics = WinningStatistics.calculate(tickets, winningNumbers, bonusNumber)

    outputWriter.printWinningStatistics(statistics)
    outputWriter.printTotalReturnRate(statistics, order.getPurchaseAmount())
}


fun generateTickets(count: Int): List<Lotto> {
    return List(count) {
        val numbers = Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, LOTTO_COUNT)
        Lotto(numbers)
    }
}