package lotto

import org.junit.jupiter.api.Test

class CashierTest {
    @Test
    fun `checkWinningNumbers updates the register in accordance with number of matches found`() {
        val cashier = Cashier(Lotto(listOf(1, 2, 3, 4, 5, 6)), 7)
        val tickets = listOf(
            listOf(1, 2, 3, 44, 55, 66),
            listOf(1, 2, 3, 4, 5, 66),
            listOf(1, 2, 3, 4, 5, 7),
            listOf(1, 2, 3, 4, 6, 7),
            listOf(1, 2, 12, 13, 14, 15),
            listOf(12, 13, 14, 15, 16, 17)
        )
        val register = cashier.checkWinningNumbers(tickets)
        assert(register[Rank.THREE] == 1)
        assert(register[Rank.FOUR] == 0)
        assert(register[Rank.FIVE] == 1)
        assert(register[Rank.SIX] == 0)
        assert(register[Rank.BONUS] == 2)
    }

    @Test
    fun `calculateStatistics returns winnings to purchase amount in percent`() {
        val cashier = Cashier(Lotto(listOf(1, 2, 3, 4, 5, 6)), 7)
        val tickets = listOf(
            listOf(1, 2, 3, 44, 55, 66),
        )
        cashier.checkWinningNumbers(tickets)
        assert(cashier.calculateStatistic(2000) == (5000.0 / 2000) * 100)
        assert(cashier.calculateStatistic(10000) == (5000.0 / 10000) * 100)
    }
}