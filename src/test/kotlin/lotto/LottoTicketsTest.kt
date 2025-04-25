package lotto

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.assertj.core.api.SoftAssertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource

class LottoTicketsTest {

    private val tickets = listOf(
        Lotto(listOf(1, 2, 3, 4, 5, 6)),  // FIRST
        Lotto(listOf(1, 2, 3, 4, 5, 7)),  // SECOND
        Lotto(listOf(1, 2, 3, 4, 5, 8)),  // THIRD
        Lotto(listOf(1, 2, 3, 4, 10, 11)), // FOURTH
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

    @ParameterizedTest
    @EnumSource
    fun `matchAll returns correct counts of Ranks`(rank: Rank) {
        // Act
        val result: Map<Rank, Int> = sut.matchAll(winningLotto)

        // Assert
        assertThat(result[rank]).isEqualTo(1)
    }

    @Test
    fun `profitRate returns 0 when no ticket wins`() {
        // Arrange
        val sut = LottoTickets(List(2) { tickets[5] })

        // Act
        val rate: Double = sut.profitRate(winningLotto)

        // Assert
        assertThat(rate).isEqualTo(0.0)
    }

    @Test
    fun `profitRate returns partial rate when some tickets win`() {
        // Arrange
        val sut = LottoTickets(listOf(tickets[4], tickets[5]))

        // Act
        val rate: Double = sut.profitRate(winningLotto)

        // Assert
        assertThat(rate).isEqualTo(250.0)
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
