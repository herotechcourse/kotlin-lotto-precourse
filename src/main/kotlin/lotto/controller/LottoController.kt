package lotto.controller

import lotto.domain.LottoMachine
import lotto.domain.LottoTicket
import lotto.view.InputView
import lotto.view.OutView
import lotto.domain.MatchLotto

class LottoController {
    init {
        var values = InputView.inputPurchase().toInt()
        val ticketCount = (values / 1000).toInt()
        val lottoMachine = LottoMachine()
        val tickets = lottoMachine.issueLotto(ticketCount)
        OutView.printTicket(tickets)

        val winNumber = InputView.inputWinNumbers()
        val winBonusNumber = InputView.inputBonusNumbers(winNumber)

        val matchResults = tickets.map { ticket ->
            val matchCount = ticket.countMatching(winNumber)
            val bonusMatch = ticket.containsBonus(winBonusNumber)
            MatchLotto.from(matchCount, bonusMatch)
        }

        val resultMap = matchResults.groupingBy { it }.eachCount()
        OutView.printStatistics(resultMap, values)

    }
}
