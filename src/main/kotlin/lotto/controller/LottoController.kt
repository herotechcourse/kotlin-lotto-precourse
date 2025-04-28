package lotto.controller

import lotto.Lotto
import lotto.LottoManager
import lotto.input.InputReader
import lotto.domain.END_NUMBER
import lotto.domain.START_NUMBER
import lotto.domain.TICKET_COST
import lotto.util.RandomNumbers
import lotto.view.OutputView

object LottoController {

    fun run() {

        val purchaseAmount = InputReader.purchaseAmount()
        val numberOfTickets = purchaseAmount / TICKET_COST

        repeat(numberOfTickets) {
            LottoManager.addTicket(Lotto(RandomNumbers.generate(START_NUMBER, END_NUMBER, 6)))
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