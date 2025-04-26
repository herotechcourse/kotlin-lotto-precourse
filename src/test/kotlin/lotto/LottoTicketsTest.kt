package lotto

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.assertj.core.api.SoftAssertions
import org.junit.jupiter.api.Test

class LottoTicketsTest {

    private val tickets = listOf(
        Lotto(listOf(1, 2, 3, 10, 11, 12)), // FIFTH
        Lotto(listOf(10, 11, 12, 13, 14, 15)) // NONE
    )
    private val sut: LottoTickets = LottoTickets(tickets)
    private val winningLotto = WinningLotto(
        Lotto(listOf(1, 2, 3, 4, 5, 6)),
        bonusNumber = 7
    )

    @Test
    fun `throws an exception when LottoTickets are empty`() {
        // Act
        // Assert
        assertThatThrownBy { LottoTickets(emptyList()) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("LottoTickets must have at least 1 ticket.")
    }

    @Test
    fun `evaluate returns WinningStatistics with correct match counts`() {
        // Act
        val result: WinningStatistics = sut.evaluate(winningLotto)

        // Assert
        SoftAssertions.assertSoftly {
            assertThat(result.getCount(Rank.THIRD)).isEqualTo(0)
            assertThat(result.getCount(Rank.FIFTH)).isEqualTo(1)
            assertThat(result.getCount(Rank.NONE)).isEqualTo(1)
        }
    }

    @Test
    fun `getTickets returns a defensive copy of the internal list`() {
        // Act
        val result: List<Lotto> = sut.getTickets()

        // Assert
        SoftAssertions.assertSoftly {
            assertThat(result).containsExactlyElementsOf(tickets)
            assertThat(result).isNotSameAs(tickets)
        }
    }

}
