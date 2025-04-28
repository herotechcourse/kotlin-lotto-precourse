package lotto

class Lotto(private val numbers: List<Int>) {
    private var bonusNumber: Int = 0

    init {
        require(numbers.size == SIZE) { "[ERROR] Lotto must contain exactly $SIZE numbers." }
        require(numbers.distinct().size == numbers.size) { "[ERROR] Lotto must contain unique numbers." }
        require(numbers.all { it in MIN..MAX}) { "[ERROR] Lotto must contain numbers in range $MIN..$MAX." }
    }

    fun setBonusNumber(number: Int) {
        require(number !in numbers) { "[ERROR] Bonus number has to be different than winning numbers." }
        require(number in MIN..MAX) { "[ERROR] Bonus number must be in range $MIN..$MAX." }
        bonusNumber = number
    }

    private fun countMatches(ticket: Ticket): Int {
        var matchCount: Int = 0
        for (winningNumber in numbers) {
            if (ticket.numbers.contains(winningNumber))
                matchCount++
        }
        return matchCount
    }

    fun compareNumbers(tickets: List<Ticket>): Map<Prize, Int> {
        val prizeCount = mutableMapOf<Prize, Int>()
        for (ticket in tickets) {
            val matchCount = countMatches(ticket)
            val hasBonus: Boolean = ticket.numbers.contains(bonusNumber)
            val prize = Prize.from(matchCount, hasBonus)
            prizeCount[prize] = prizeCount.getOrDefault(prize, 0) + 1 // use get or default to avoid NullPointerException
        }
        return prizeCount
    }

    fun calculateTotalPrize(prizeCount: Map<Prize, Int>): Int {
        var totalPrize: Int = 0
        for (prize in prizeCount) {
            totalPrize += prize.value * prize.key.money
        }
        return totalPrize
    }

    companion object {
        private const val MIN = 1
        private const val MAX = 45
        private const val SIZE = 6
    }
}
