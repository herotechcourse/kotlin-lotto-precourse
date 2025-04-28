package lotto.orchestrator

import lotto.input.InputView
import lotto.output.OutputView
import lotto.process.StatisticsCalculator
import lotto.process.TicketGenerator

class LottoRankOrchestrator {

    private val inputView: InputView = InputView()
    private val ticketGenerator = TicketGenerator()
    private val outputView = OutputView()
    private val statisticsCalculator = StatisticsCalculator()

    fun executeLotto(){
        val purchaseAmount = inputView.getPurchaseAmount()
        val purchasedTickets = ticketGenerator.generateTickets(purchaseAmount)
        outputView.displayTickets(purchasedTickets)
        val winningLotto = inputView.getLottoNumber()
        val bonusNumber = inputView.getBonusNumber(winningLotto)
        val lottoRanks = statisticsCalculator.calculateLottoRanks(purchasedTickets, winningLotto, bonusNumber)
        val returnRate = statisticsCalculator.calculateReturnRate(lottoRanks, purchaseAmount)
        outputView.generateLottoResult(lottoRanks)
        outputView.generateReturnRate(returnRate)
    }
}