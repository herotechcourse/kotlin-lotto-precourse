package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class BudgetTest {
    @Test
    fun `throws an exception when the purchase amount cannot be divisible by 1,000`() {
        assertThrows<IllegalArgumentException> {
            Budget(1500)
        }
    }
}
