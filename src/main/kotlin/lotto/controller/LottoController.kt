package lotto.controller

import lotto.Lotto
import lotto.model.LottoResult
import lotto.model.LottoTickets
import lotto.model.Money
import lotto.model.PrizeRank
import lotto.view.InputView
import lotto.view.OutputView

class LottoController(
    private val inputView: InputView,
    private val outputView: OutputView
) {

    fun run() {
        try {
            val money = Money(inputView.readPurchaseAmount())

            outputView.printTicketCount(money.getTicketCount())

            val lottoTickets = LottoTickets(money.getTicketCount())
            outputView.printLottoTickets(lottoTickets.getTickets())

            val winningLotto = Lotto(inputView.readLastWinningNumber())

            val bonusNumber = inputView.readLastBonusNumber()

            if (winningLotto.getNumbers().contains(bonusNumber)) {
                throw IllegalArgumentException("[ERROR] Bonus number must not be included in winning numbers.")
            }

            val lottoResult = LottoResult()

            for (ticket in lottoTickets.getTickets()) {
                val matchCount = ticket.getNumbers().count { it in winningLotto.getNumbers() }
                val bonusMatch = ticket.getNumbers().contains(bonusNumber)

                val prizeRank = PrizeRank.find(matchCount, bonusMatch)
                lottoResult.record(prizeRank)
            }

            outputView.printWinningStatistics(lottoResult, money.getAmount())

        } catch (e: IllegalArgumentException) {
            println(e.message)
        }
    }

}
