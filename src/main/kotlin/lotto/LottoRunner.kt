package lotto

class LottoRunner {
    private val ticketMachine = LottoInitializer.ticketMachineFromInput()
    private val lottoCalculator: LottoCalculator

    init {
        OutputView.printTickets(ticketMachine.tickets)
        lottoCalculator = LottoInitializer.lottoCalculatorFromInput()
    }

    fun lottoResults() {
        OutputView.printResults(lottoCalculator.checkWinningNumbers(ticketMachine.tickets))
        OutputView.printStatistics(lottoCalculator.calculateStatistic(ticketMachine.purchaseAmount))
    }
}