package lotto

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class BudgetTest {
    @Test
    fun `throws an exception when the purchase amount cannot be divisible by 1,000`() {
        assertThrows<IllegalArgumentException> {
            Budget(1500)
        }
    }

    @Test
    fun `The number of tickets is as much as the purchase amount divided into 1000`() {
        val budget = Budget(3000)

        assertEquals(3, budget.ticketCounts())
    }
}
