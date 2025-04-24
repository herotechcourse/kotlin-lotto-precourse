package lotto.controller

import lotto.Lotto
import lotto.model.LottoManager
import lotto.model.User
import lotto.utils.InputValidator
import lotto.view.InputView
import lotto.view.OutputView

class LottoController(
    private val inputView: InputView,
    private val outputView: OutputView,
    private val inputValidator: InputValidator,
) {

    fun run() {
        // Input (Budget)
        val budget = inputView.readPurchaseAmount().toLong() // just for test
        val user: User = User(budget)

        // Output (Purchased Tickets)
        outputView.printPurchasedTickets(user)
        outputView.printNewLine()

        // Input (Winner Lotto)
        val winnerNumbers = inputView.readWinnerLotto().split(",").map { it.trim().toInt() }
        outputView.printNewLine()

        // Input (Bonus Number)
        val winnerBonusNumber = inputView.readBonusNumber().toInt()
        outputView.printNewLine()

        val winnerLotto = Lotto(winnerNumbers, winnerBonusNumber)

        val lottoManager = LottoManager(winnerLotto, user)

        // Output (Winner Statistic)
        outputView.printWinningStatistics(lottoManager)

    }
}