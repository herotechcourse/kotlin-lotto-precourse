package lotto.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class WinningLottoTest {

    @Test
    fun `TEST_Create WinningLotto with valid numbers`() {
        val winningTicket = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val bonus = 7

        val winningLotto = WinningLotto(winningTicket, bonus)

        assertThat(winningLotto.ticket).isEqualTo(winningTicket)
        assertThat(winningLotto.bonusNumber).isEqualTo(bonus)
    }

    @Test
    fun `EXCEPTION_Bonus number out of valid range`() {
        val winningTicket = Lotto(listOf(1, 2, 3, 4, 5, 6))

        val exception = assertThrows<IllegalArgumentException> {
            WinningLotto(winningTicket, 46)
        }

        assertThat(exception.message).contains(ERROR_MESSAGE)
    }

    @Test
    fun `EXCEPTION_Bonus number is one of the winning numbers`() {
        val winningTicket = Lotto(listOf(1, 2, 3, 4, 5, 6))

        val exception = assertThrows<IllegalArgumentException> {
            WinningLotto(winningTicket, 6)
        }

        assertThat(exception.message).contains(ERROR_MESSAGE)
    }

    companion object {
        private const val ERROR_MESSAGE: String = "[ERROR]"
    }
}
