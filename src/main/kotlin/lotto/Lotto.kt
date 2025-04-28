package lotto

class Lotto(private val numbers: List<Int>) {
    private var bonusNumber: Int = 0

    init {
        require(numbers.size == 6) { "[ERROR] Lotto must contain exactly 6 numbers." }
        require(numbers.distinct().size == numbers.size) { "[ERROR] Lotto must contain unique numbers." }
        numbers.forEach {
            number -> require(number in 1..45) { "[ERROR] Lotto must contain numbers in range 1..45." }
        }
    }

    fun addBonusNumber(number: Int) {
        require(number !in numbers) { "[ERROR] Bonus number has to be different than winning numbers." }
        require(number in 1..45) { "[ERROR] Bonus number must be in range 1..45." }
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
            totalPrize += prize.component2() * prize.key.money
        }
        return totalPrize
    }
}
