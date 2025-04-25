package lotto.domain

import lotto.Lotto
import lotto.view.InputView
import lotto.view.OutputView

class Game {
    fun run() {
        val ticketsPurchased = TicketMachine.buy()
        val winningSet = Lotto(InputView.getWinningNumbers())
        val bonusNumber = InputView.getBonusNumber()
        OutputView.printStats()
    }
}
