package lotto

import camp.nextstep.edu.missionutils.Randoms
import lotto.io.InputHandler
import lotto.io.OutputHandler

fun main() {
    val tickets = mutableListOf<Lotto>()

    val sumOfMoney = InputHandler.getSumOfMoney()
    val numberOfTickets = getNumberOfTickets(sumOfMoney)

    repeat(numberOfTickets) {
        val ticket = Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted())
        tickets.add(ticket)
    }
    OutputHandler.showTickets(tickets)

    val winningNumbers = InputHandler.getWinningNumbers()
    val bonusNumber = InputHandler.getBonusNumber()

    val game = LottoGame(tickets, winningNumbers, bonusNumber)
    val results = game.start()
    val totalRate = results.countReturnRate(sumOfMoney)

    OutputHandler.showStatistics(results)
    OutputHandler.showTotalRate(totalRate)
}

fun getNumberOfTickets(sum: Int): Int {
    return sum / TICKET_PRICE
}
