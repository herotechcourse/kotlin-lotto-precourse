package lotto

class LottoRunner {
    private val ticketMachine = LottoInitializer.ticketMachineFromInput()
    private val cashier:Cashier
    init {
        OutputView.printTickets(ticketMachine.tickets)
        cashier = LottoInitializer.cashierFromInput()
    }
    fun lottoResults(){
        OutputView.printResults(cashier.checkWinningNumbers(ticketMachine.tickets))
        OutputView.printStatistics(cashier.calculateStatistic(ticketMachine.purchaseAmount))
    }
}