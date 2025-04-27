package lotto.domain

import lotto.Lotto
import lotto.view.InputView
import lotto.view.OutputView

/*Note:
Currently, PlayerData is kept simple as a data class, mainly for storing player-related information.
However, if the application was meant to expand (supporting multiple players or more complex player behaviors),
it would be better to refactor this into a full Player class that encapsulates behaviors like buying tickets,
comparing tickets, finding results, and calculating profit. */
data class PlayerData(
    val moneySpent: Int,
    val lottoTickets: List<Lotto>,
    var rankResults: Map<Rank, Pair<Int, Int>> = emptyMap(),
    var prizeSum: Int = 0,
    var returnRate: Double = 0.0
)

class Game {
    fun run() {
        val playerData = TicketMachine.buy()
        // TODO: consider regrouping winning numbers and bonus into a dedicated WinningTicket class for better structure.
        val winningLotto = Lotto(InputView.getWinningNumbers())
        val bonusNumber = InputView.getBonusNumber()
        WinningStatistics.get(playerData, winningLotto, bonusNumber)
        OutputView.printStats(playerData)
    }
}
