package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class MoneyTest {

    @Test
    fun `creates Money object with valid amount`() {
        val money = Money(14000)
        assertThat(money.amount).isEqualTo(14000)
    }

    @Test
    fun `throws exception when amount is not divisible by 1000`() {
        assertThatThrownBy { Money(1234) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("[ERROR]")
    }

    @Test
    fun `throws exception when amount is negative`() {
        assertThatThrownBy { Money(-1000) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("[ERROR]")
    }

}