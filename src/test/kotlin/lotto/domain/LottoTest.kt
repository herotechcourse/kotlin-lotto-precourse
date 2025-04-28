package lotto.domain

import lotto.Lotto
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class LottoTest {

    @Test
    fun `creates a LottoTicket with exactly 6 unique numbers`() {
        val numbers = listOf(1, 2, 3, 4, 5, 6)
        val ticket = Lotto(numbers)

        assertThat(ticket.getNumbers()).hasSize(6)
        assertThat(ticket.getNumbers().toSet().size).isEqualTo(6)
    }

    @Test
    fun `throws exception when LottoTicket does not have exactly 6 numbers`() {
        val numbers = listOf(1, 2, 3, 4, 5)

        assertThatThrownBy { Lotto(numbers) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("[ERROR]")
    }

    @Test
    fun `throws exception when LottoTicket has duplicate numbers`() {
        val numbers = listOf(1, 2, 2, 3, 4, 5)

        assertThatThrownBy { Lotto(numbers) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("[ERROR]")
    }

}