package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LotteryTicketMachineTest {
    @Test
    fun `throws exception when purchase amount is not divisible by 1,000`() {
        assertThrows<IllegalArgumentException> {
            LotteryTicketMachine.validatePurchaseAmount(1500)
        }
    }
}