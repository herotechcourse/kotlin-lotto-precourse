package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class IssuedTicketTest {

    @Test
    fun `throws an exception when purchase amount is negative`() {
        assertThrows<IllegalArgumentException> {
            IssuedTicket(-1000, DefaultRandomGenerator())
        }
    }

    @Test
    fun `throws an exception when purchase amount is zero`() {
        assertThrows<IllegalArgumentException> {
            IssuedTicket(0, DefaultRandomGenerator())
        }
    }

    @Test
    fun `throws an exception when purchase amount is divided by 1000, the remainder is not zero`() {
        assertThrows<IllegalArgumentException> {
            IssuedTicket(2500, DefaultRandomGenerator())
        }
    }
}
