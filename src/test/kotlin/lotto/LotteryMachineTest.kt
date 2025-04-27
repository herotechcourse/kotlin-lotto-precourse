package lotto

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LotteryMachineTest {
    @Test
    fun `generate lotto tickets as much as the budget`() {
        val lotteryMachine = LotteryMachine(Budget(5000), StubNumbersStrategy())

        assertEquals(5, lotteryMachine.generateTickets().size)
    }
}
