package lotto.domain

import lotto.Lotto
import lotto.domain.WinningSet
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
        val winningSet = WinningSet()
        WinningStatistics.get(playerData, winningSet)
        OutputView.printStats(playerData)
    }
}
