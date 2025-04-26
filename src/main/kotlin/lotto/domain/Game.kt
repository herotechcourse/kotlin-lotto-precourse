package lotto.domain

import lotto.Lotto
import lotto.view.InputView
import lotto.view.OutputView

class Game {
    fun run() {
        val playerData = TicketMachine.buy()
        val winningSet = Lotto(InputView.getWinningNumbers())
        val bonusNumber = InputView.getBonusNumber()
       OutputView.printStats()
    }
}
