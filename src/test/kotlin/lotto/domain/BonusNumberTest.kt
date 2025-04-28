package lotto.domain

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class BonusNumberTest {
    @Test
    fun `throws an exception when bonus number is empty string`() {
        assertThrows<IllegalArgumentException> {
            BonusNumber.from("")
        }
    }

    @Test
    fun `throws an exception when bonus number is blank`() {
        assertThrows<IllegalArgumentException> {
            BonusNumber.from("       ")
        }
    }

    @Test
    fun `throws an exception when bonus number is not a number`() {
        assertThrows<IllegalArgumentException> {
            BonusNumber.from("abc")
        }
    }

    @Test
    fun `throws an exception when bonus number is not positive number`() {
        assertThrows<IllegalArgumentException> {
            BonusNumber.from("-5")
        }

        assertThrows<IllegalArgumentException> {
            BonusNumber.from("0")
        }
    }

    @Test
    fun `throws an exception when bonus number is not in range`() {
        assertThrows<IllegalArgumentException> {
            BonusNumber.from("-1")
        }

        assertThrows<IllegalArgumentException> {
            BonusNumber.from("46")
        }
    }
}