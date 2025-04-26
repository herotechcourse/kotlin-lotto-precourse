package lotto

class LotteryMachine(private val budget: Budget, private val strategy: GenerateStrategy) {
    fun generateTickets(): List<Lotto> {
        return List(budget.ticketCounts()) {
            Lotto(strategy.generate())
        }
    }
}
