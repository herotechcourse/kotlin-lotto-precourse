package lotto.controller

import lotto.common.LottoUtil
import lotto.model.*
import lotto.view.*

class LottoController {

    fun run() {
        val money = Money(InputView.readPurchaseAmount())
        val tickets = LottoMachine.purchase(money)
        OutputView.printPurchasedTickets(tickets.size, tickets.map { it.getNumbers() })
        val prizes = LottoMachine.simulate(tickets, Winner(InputView.readWinningNumbers(), InputView.readBonusNumber()))
        val profitRate = LottoUtil.calculateProfitRate(LottoUtil.calculateProfit(prizes), money.getAmount())
        OutputView.printWinningStatistics(prizes, profitRate)
    }

}