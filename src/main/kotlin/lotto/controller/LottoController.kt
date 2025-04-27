package lotto.controller

import lotto.Lotto
import lotto.model.Game
import lotto.model.LottoTicketMachine
import lotto.model.WinningLotto
import lotto.view.InputView
import lotto.view.MatchResultDto
import lotto.view.OutputView

class LottoController() {

    private val inputView: InputView = InputView()
    private val outputView: OutputView = OutputView()
    private val lottoTicketMachine: LottoTicketMachine = LottoTicketMachine()

    fun start() {
        outputView.askPurchaseAmount()
        val purchaseAmount = inputView.askPurchaseAmount()

        val purchaseQuantity = purchaseAmount.amount / 1_000

        val lottoTicket = lottoTicketMachine.buyLotto(purchaseQuantity)
        outputView.printPurchasedLottoTicket(purchaseQuantity, lottoTicket)

        outputView.askWinningNumbers()
        val winningNumbers = inputView.askWinningNumbers()

        outputView.askBonusNumber()
        val bonusNumber = inputView.askBonusNumber()

        val winningLotto = WinningLotto(Lotto(winningNumbers.winningNumbers), bonusNumber.bonusNumber)

        val game = Game(purchaseAmount.amount, lottoTicket, winningLotto)
        val matchResult = game.match()

        val matchResultDto = MatchResultDto.getMatchResultDto(matchResult)
        val returnRate = game.countReturnRate()
        outputView.printWinningStatistics(matchResultDto, returnRate)
    }
}