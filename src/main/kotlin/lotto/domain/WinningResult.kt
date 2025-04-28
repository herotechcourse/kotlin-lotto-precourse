package lotto.domain

class WinningResult(
    private val lottos: List<Lotto>,
    private val winningLotto: WinningLotto
) {
    private val prizeCountMap: Map<Prize, Int> by lazy {
        calculatePrizeResults()
    }
    
    private fun calculatePrizeResults(): Map<Prize, Int> {
        return lottos
            .map { winningLotto.getPrize(it) }
            .groupingBy { it }
            .eachCount()
            .filterKeys { it != Prize.NONE }
    }
    
    fun getWinningTicketsByPrize(): Map<Prize, Int> {
        return prizeCountMap
    }
    
    fun calculateTotalWinningAmount(): Int {
        return prizeCountMap.entries.sumOf { (prize, count) -> 
            prize.amount * count 
        }
    }
    
    fun calculateReturnRate(purchaseAmount: Int): Double {
        return calculateTotalWinningAmount().toDouble() / purchaseAmount * 100
    }
} 