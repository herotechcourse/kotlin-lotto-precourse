package lotto.domain


import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class MoneyTest {

    @Test
    fun `throws exception when money is less than 1,000`() {
        assertThrows<IllegalArgumentException> {
            Money(999)
        }
    }

    @Test
    fun `throws exception when money is not divisible by 1,000`() {
        assertThrows<IllegalArgumentException> {
            Money(1250)
        }
    }

    @Test
    fun `returns correct ticket count`() {
        val money = Money(5000)
        assertThat(money.countTickets()).isEqualTo(5)
    }

    @Test
    fun `returns correct amount value`() {
        val money = Money(3000)
        assertThat(money.value()).isEqualTo(3000)
    }
}