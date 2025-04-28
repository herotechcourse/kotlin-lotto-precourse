package lotto.controller

import lotto.Lotto
import lotto.model.LottoTickets
import lotto.model.Money
import lotto.view.InputView
import lotto.view.OutputView

class LottoController(
    private val inputView: InputView,
    private val outputView: OutputView
) {

    fun run() {
        val purchaseAmountInput = inputView.readPurchaseAmount()
        val money = Money(purchaseAmountInput.toInt())

        val ticketCount = money.getTicketCount()
        outputView.printTicketCount(ticketCount)

        val lottoTickets = LottoTickets(ticketCount)
        outputView.printLottoTickets(lottoTickets.getTickets())

        val winningNumbersInput = inputView.readLastWinningNumber()
        val winningNumbers = winningNumbersInput.split(",").map { it.trim().toInt() }
        val winningLotto = Lotto(winningNumbers)

        val bonusNumberInput = inputView.readLastBonusNumber()
        val bonusNumber = bonusNumberInput.toInt()

        if (winningNumbers.contains(bonusNumber)) {
            throw IllegalArgumentException("[ERROR] Bonus number must not be included in winning numbers.")
        }

    }
}
