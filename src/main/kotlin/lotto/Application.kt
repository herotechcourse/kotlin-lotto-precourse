package lotto

import camp.nextstep.edu.missionutils.Randoms
import lotto.constants.TICKET_PRICE
import lotto.io.InputView
import lotto.io.OutputView

fun main() {
    val tickets = mutableListOf<Lotto>()

    val sumOfMoney = InputView.getSumOfMoney()
    val numberOfTickets = getNumberOfTickets(sumOfMoney)

    repeat(numberOfTickets) {
        val ticket = Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted())
        tickets.add(ticket)
    }
    OutputView.showTickets(tickets)

    val winningNumbers = InputView.getWinningNumbers()
    val bonusNumber = InputView.getBonusNumber()

    val game = LottoGame(tickets, winningNumbers, bonusNumber)
    val results = game.start()
    val totalRate = results.countReturnRate(sumOfMoney)

    OutputView.showStatistics(results)
    OutputView.showTotalRate(totalRate)
}

fun getNumberOfTickets(sum: Int): Int {
    return sum / TICKET_PRICE
}
