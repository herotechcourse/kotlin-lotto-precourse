package lotto.controller

import lotto.Lotto
import lotto.model.Game
import lotto.model.LottoTicketMachine
import lotto.model.WinningLotto
import lotto.view.InputView
import lotto.view.LottoTicketDto
import lotto.view.MatchResultDto

class LottoController() {

    private val inputView: InputView = InputView()
    private val lottoTicketMachine: LottoTicketMachine = LottoTicketMachine()

    fun start() {
        println("Please enter the purchase amount")
        val purchaseAmount = inputView.askPurchaseAmount()
        val purchaseQuantity = purchaseAmount.amount / 1_000
        println()
        println("You have purchased $purchaseQuantity tickets.")
        val lottoTicket = lottoTicketMachine.buyLotto(purchaseQuantity)
        lottoTicket.map { lotto ->
            LottoTicketDto(lotto.getNumbers())
        }.forEach {
            println(it.numbers)
        }
        println()
        println("Please enter last week's winning numbers.")
        val winningNumbers = inputView.askWinningNumbers()
        println()
        println("Please enter the bonus number.")
        val bonusNumber = inputView.askBonusNumber()
        val winningLotto = WinningLotto(Lotto(winningNumbers.winningNumbers), bonusNumber.bonusNumber)
        println()
        println("Winning Statistics")
        println("---")
        val game = Game(purchaseAmount.amount, lottoTicket, winningLotto)
        val matchResult = game.match()
        println(MatchResultDto.getMatchResultDto(matchResult).output)
        val returnRate = game.countReturnRate()
        println("Total return rate is $returnRate%.")
    }
}