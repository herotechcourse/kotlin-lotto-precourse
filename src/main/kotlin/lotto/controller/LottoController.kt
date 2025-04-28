package lotto.controller

import lotto.Lotto
import lotto.LottoManager
import lotto.input.InputReader
import lotto.input.end
import lotto.input.start
import lotto.input.ticketCost
import lotto.util.RandomNumbers
import lotto.view.OutputView

object LottoController {

    fun run() {

        val purchaseAmount = InputReader.purchaseAmount()
        val numberOfTickets = purchaseAmount / ticketCost

        repeat(numberOfTickets) {
            LottoManager.addTicket(Lotto(RandomNumbers.generate(start, end, 6)))
        }

        OutputView.printNumberOfTickets(numberOfTickets)
        OutputView.printTickets(LottoManager.getTickets())

        //val winningTicket = Lotto(InputReader.winningNumbers())
        val winningTicket = InputReader.winningNumbers()
        val bonusNumber = InputReader.bonusNumber(winningTicket.getNumbers())

        LottoManager.makeRankTable(winningTicket, bonusNumber)

        OutputView.printWinningStatistics(LottoManager.getRankTable(), LottoManager.returnRate(purchaseAmount))
    }
}