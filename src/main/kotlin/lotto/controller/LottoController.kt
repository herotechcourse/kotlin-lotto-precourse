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
            // Read and validate the purchase amount
            val money = Money(inputView.readPurchaseAmount())

            // Print the number of tickets purchased
            outputView.printTicketCount(money.getTicketCount())

            // Issue lottery tickets and display them
            val lottoTickets = LottoTickets(money.getTicketCount())
            outputView.printLottoTickets(lottoTickets.getTickets())

            // Read last week's winning numbers
            val winningLotto = Lotto(inputView.readLastWinningNumber())

            // Read the bonus number
            val bonusNumber = inputView.readLastBonusNumber()

            // Validate that the bonus number is not duplicated in the winning numbers
            if (winningLotto.getNumbers().contains(bonusNumber)) {
                throw IllegalArgumentException("[ERROR] Bonus number must not be included in winning numbers.")
            }

            // Initialize result storage
            val lottoResult = LottoResult()

            // Compare each ticket against the winning numbers and record results
            for (ticket in lottoTickets.getTickets()) {
                val matchCount = ticket.getNumbers().count { it in winningLotto.getNumbers() }
                val bonusMatch = ticket.getNumbers().contains(bonusNumber)

                val prizeRank = PrizeRank.find(matchCount, bonusMatch)
                lottoResult.record(prizeRank)
            }

            // Print the final statistics and profit rate
            outputView.printWinningStatistics(lottoResult, money.getAmount())

        } catch (e: IllegalArgumentException) {
            println(e.message)
        }
    }

}
