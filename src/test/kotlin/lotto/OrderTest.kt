package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class OrderTest {
    @Test
    fun `throws an exception when purchase amount is zero`() {
        assertThrows<IllegalArgumentException> {
            Order(0)
        }
    }

    @Test
    fun `throws an exception when purchase amount is negative`() {
        assertThrows<IllegalArgumentException> {
            Order(-1)
        }
    }

    @Test
    fun `throws an exception when purchase amount is not a multiple of LOTTO price`() {
        assertThrows<IllegalArgumentException> {
            Order(1500)
        }
    }
}
