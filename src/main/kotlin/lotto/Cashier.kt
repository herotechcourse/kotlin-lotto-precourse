package lotto

const val BONUS: Int = 7

class Cashier(private val lotto: Lotto, private val bonusNumber: Int) {
    private val register: MutableMap<Rank, Int> = enumValues<Rank>().associateWith { 0 }.toMutableMap()

    fun checkWinningNumbers(tickets: List<List<Int>>): Map<Rank, Int> {
        for (ticket in tickets) {
            var numberOfMatches = lotto.numberOfMatches(ticket)
            if (numberOfMatches == 5 && ticket.contains(bonusNumber)) numberOfMatches = BONUS
            updateRegister(numberOfMatches)
        }
        return register
    }

    private fun updateRegister(numberOfMatches: Int) {
        when (numberOfMatches) {
            3 -> register[Rank.THREE] = register.getValue(Rank.THREE) + 1
            4 -> register[Rank.FOUR] = register.getValue(Rank.FOUR) + 1
            5 -> register[Rank.FIVE] = register.getValue(Rank.FIVE) + 1
            6 -> register[Rank.SIX] = register.getValue(Rank.SIX) + 1
            BONUS -> register[Rank.BONUS] = register.getValue(Rank.BONUS) + 1
        }
    }

    fun calculateStatistic(purchasePrice: Int): Double {
        var winnings: Double = 0.0
        for (entry in register) winnings += entry.key.winning * entry.value
        return ((winnings / purchasePrice) * 100)
    }
}