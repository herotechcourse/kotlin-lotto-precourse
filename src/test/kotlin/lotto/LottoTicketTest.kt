package lotto

import lotto.domain.LottoTicket
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class LottoTicketTest {
    @Test
    fun `shouldThrowExceptionIfTicketSizeIsNotSix`() {
        assertThatThrownBy { LottoTicket(listOf(1, 2, 3, 4, 5)) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("A lotto ticket must have exactly 6 numbers")
    }

    @Test
    fun `shouldSortTicketNumbersInAscendingOrder`() {
        val ticket = LottoTicket(listOf(5, 1, 9, 3, 2, 6))
        assertThat(ticket.getNumbers()).isEqualTo(listOf(1, 2, 3, 5, 6, 9))
    }

    @Test
    fun `shouldCountMatchingNumbersCorrectly`() {
        val ticket = LottoTicket(listOf(1, 2, 3, 4, 5, 6))
        val winningNumbers = listOf(1, 2, 7, 8, 9, 10)
        assertThat(ticket.countMatching(winningNumbers)).isEqualTo(2)
    }

    @Test
    fun `shouldCheckIfBonusNumberIsContained`() {
        val ticket = LottoTicket(listOf(1, 2, 3, 4, 5, 6))
        assertThat(ticket.containsBonus(6)).isTrue()
        assertThat(ticket.containsBonus(7)).isFalse()
    }
}
