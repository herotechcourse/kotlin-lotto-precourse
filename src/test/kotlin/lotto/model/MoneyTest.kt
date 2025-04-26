package lotto.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class MoneyTest {

    @Test
    fun `valid amount should create Money successfully`() {
        val money = Money(8000)
        assertThat(money.getTicketCount()).isEqualTo(8)
    }

    @Test
    fun `amount not multiple of 1000 should throw exception`() {
        assertThrows<IllegalArgumentException> {
            Money(8500)
        }
    }

    @Test
    fun `zero or negative amount should throw exception`() {
        assertThrows<IllegalArgumentException> {
            Money(0)
        }
        assertThrows<IllegalArgumentException> {
            Money(-1000)
        }
    }
}