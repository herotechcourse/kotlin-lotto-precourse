package lotto

class LottoGame(private val inputView: InputView, private val outputView: OutputView) {
    
    fun play() {
        val purchaseAmount = getPurchaseAmount()
        val ticketCount = purchaseAmount / TICKET_PRICE
        val lottoMachine = LottoMachine()
        val tickets = lottoMachine.generateTickets(ticketCount)
        
        outputView.printTickets(tickets)
        
        val winningNumbers = getWinningNumbers()
        val bonusNumber = getBonusNumber(winningNumbers)
        
        val winningChecker = WinningChecker(winningNumbers, bonusNumber)
        val results = tickets.map { winningChecker.checkLotto(it) }
        
        val statistics = calculateStatistics(results)
        val returnRate = calculateReturnRate(statistics, purchaseAmount)
        
        outputView.printResults(statistics, returnRate)
    }
    
    private fun getPurchaseAmount(): Int {
        while (true) {
            try {
                val amount = inputView.readPurchaseAmount()
                validatePurchaseAmount(amount)
                return amount
            } catch (e: IllegalArgumentException) {
                outputView.printError(e.message ?: "Invalid input")
            }
        }
    }
    
    private fun validatePurchaseAmount(amount: Int) {
        if (amount <= 0) {
            throw IllegalArgumentException("[ERROR] Purchase amount must be positive.")
        }
        if (amount % TICKET_PRICE != 0) {
            throw IllegalArgumentException("[ERROR] Purchase amount must be divisible by $TICKET_PRICE.")
        }
    }
    
    private fun getWinningNumbers(): List<Int> {
        while (true) {
            try {
                return inputView.readWinningNumbers()
            } catch (e: IllegalArgumentException) {
                outputView.printError(e.message ?: "Invalid input")
            }
        }
    }
    
    private fun getBonusNumber(winningNumbers: List<Int>): Int {
        while (true) {
            try {
                val bonusNumber = inputView.readBonusNumber()
                validateBonusNumber(bonusNumber, winningNumbers)
                return bonusNumber
            } catch (e: IllegalArgumentException) {
                outputView.printError(e.message ?: "Invalid input")
            }
        }
    }
    
    private fun validateBonusNumber(bonusNumber: Int, winningNumbers: List<Int>) {
        if (bonusNumber !in 1..45) {
            throw IllegalArgumentException("[ERROR] Bonus number must be between 1 and 45.")
        }
        if (bonusNumber in winningNumbers) {
            throw IllegalArgumentException("[ERROR] Bonus number must not be one of the winning numbers.")
        }
    }
    
    private fun calculateStatistics(results: List<LottoResult>): Map<LottoResult, Int> {
        return results.groupingBy { it }.eachCount()
    }
    
    private fun calculateReturnRate(statistics: Map<LottoResult, Int>, purchaseAmount: Int): Double {
        val totalWinnings = statistics.entries.sumOf { (result, count) -> 
            result.prize * count.toLong() 
        }
        return (totalWinnings.toDouble() / purchaseAmount) * 100
    }
    
    companion object {
        const val TICKET_PRICE = 1000
    }
}