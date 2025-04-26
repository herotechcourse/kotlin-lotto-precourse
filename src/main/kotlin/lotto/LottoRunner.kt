package lotto

class LottoRunner {
    private val cashier = LottoInitializer.cashierFromInput()
    private val ticketMachine = LottoInitializer.ticketMachineFromInput()
    private val tickets:List<List<Int>> = ticketMachine.tickets
    init {
        OutputView.PRINT_TICKETS.printMessage(tickets)
    }
    fun lottoResults(){
        val lottoResults = cashier.checkWinningNumbers(tickets)
        OutputView.PRINT_RESULT.printMessage(lottoResults)
    }
}