package lotto.domain

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue

class LottoNumberTest {
    @Test
    fun `create valid lotto number`() {
        val number = LottoNumber.from(1)
        assertEquals(1, number.value)
    }

    @Test
    fun `throw exception when number is less than 1`() {
        assertThrows<IllegalArgumentException> {
            LottoNumber.from(0)
        }
    }

    @Test
    fun `throw exception when number is greater than 45`() {
        assertThrows<IllegalArgumentException> {
            LottoNumber.from(46)
        }
    }

    @Test
    fun `generate all lotto numbers`() {
        val numbers = LottoNumber.values()
        assertEquals(45, numbers.size)
        assertTrue(numbers.all { it.value in 1..45 })
    }

    @Test
    fun `equals and hashCode`() {
        val number1 = LottoNumber.from(1)
        val number2 = LottoNumber.from(1)
        assertEquals(number1, number2)
        assertEquals(number1.hashCode(), number2.hashCode())
    }

    @Test
    fun `toString returns number as string`() {
        val number = LottoNumber.from(1)
        assertEquals("1", number.toString())
    }
} 