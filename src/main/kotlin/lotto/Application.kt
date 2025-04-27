package lotto

import camp.nextstep.edu.missionutils.Randoms
import lotto.io.InputHandler
import lotto.io.OutputHandler
import lotto.validators.InputValidator


fun main() {
    val sumOfMoney = InputHandler.getSumOfMoney()
    InputValidator.validateSumOfMoney(sumOfMoney)

    val numberOfTickets = getNumberOfTickets(sumOfMoney)
    val tickets = mutableListOf<Lotto>()
    repeat(numberOfTickets) {
        val ticket = Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted())
        tickets.add(ticket)
    }
    OutputHandler.showTickets(tickets)

    val winningNumbers = InputHandler.getWinningNumbers()
    InputValidator.validateNumbers(winningNumbers)

    val bonusNumber = InputHandler.getBonusNumber()
    InputValidator.validateNumberInRange(bonusNumber)

    val game = LottoGame(tickets, winningNumbers, bonusNumber)
    val results = game.start()
    val totalRate = results.countReturnRate(sumOfMoney)

    OutputHandler.showStatistics(results)
    OutputHandler.showTotalRate(totalRate)
}

fun getNumberOfTickets(sum: Int): Int {
    return sum / 1000
}
