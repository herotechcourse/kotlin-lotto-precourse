package lotto

import org.junit.jupiter.api.Test

class CashierTest {
    @Test
    fun `checkWinningNumbers updates the register in accordance with number of matches found`(){
        val cashier = Cashier(Lotto(listOf(1,2,3,4,5,6)),7)
        val tickets = listOf(
            listOf(1,2,3,44,55,66),
            listOf(1,2,3,4,5,66),
            listOf(1,2,3,4,5,7),
            listOf(1,2,3,4,6,7),
            listOf(1,2,12,13,14,15),
            listOf(12,13,14,15,16,17)
        )
        val register = cashier.checkWinningNumbers(tickets)
        assert(register[3] == 1)
        assert(register[4] == 0)
        assert(register[5] == 1)
        assert(register[6] == 0)
        assert(register[7] == 2)
    }
}