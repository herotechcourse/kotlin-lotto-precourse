package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.assertj.core.api.Assertions.assertThat

class LottoTest {
    @Test
    fun `throws an exception when lotto numbers exceed six`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 6, 7))
        }
    }

    // TODO: Implement production code to pass the test
    @Test
    fun `throws an exception when lotto numbers contain duplicates`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 5))
        }
    }

    // TODO: Implement tests based on the added features

    @Test
    fun `generate correct number of tickets`() {
        // Given
        val machine = Machine()
        val numberOfTickets = 5

        // When
        val tickets = machine.generateTickets(numberOfTickets)

        // Then
        assertThat(tickets).hasSize(numberOfTickets)
        tickets.forEach { ticket ->
            assertThat(ticket.getNumbers())
                .hasSize(6)
                .allMatch { it in 1..45 }
        }
    }
    @Test
    fun `create WinningNumbers correctly`() {
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = 7
        val winning = WinningNumbers(winningNumbers, bonusNumber)
        assertThat(winning.getWinningNumbers()).containsExactlyInAnyOrder(1, 2, 3, 4, 5, 6)
        assertThat(winning.getBonusNumber()).isEqualTo(7)
    }
    @Test
    fun `Rank matches correctly based on match count and bonus`() {
        assertThat(Rank.from(6, false)).isEqualTo(Rank.FIRST)
        assertThat(Rank.from(5, true)).isEqualTo(Rank.SECOND)
        assertThat(Rank.from(5, false)).isEqualTo(Rank.THIRD)
        assertThat(Rank.from(4, false)).isEqualTo(Rank.FOURTH)
        assertThat(Rank.from(3, false)).isEqualTo(Rank.FIFTH)
        assertThat(Rank.from(2, false)).isEqualTo(Rank.NONE)
    }
    @Test
    fun `calculate result counts correctly`() {
        // Given
        val tickets = listOf(
            Ticket(listOf(1, 2, 3, 4, 5, 6)), // 6 matches -> FIRST
            Ticket(listOf(1, 2, 3, 4, 5, 7)), // 5 matches + bonus -> SECOND
            Ticket(listOf(1, 2, 3, 4, 5, 8)), // 5 matches -> THIRD
            Ticket(listOf(1, 2, 3, 4, 9, 10)), // 4 matches -> FOURTH
            Ticket(listOf(1, 2, 3, 11, 12, 13)) // 3 matches -> FIFTH
        )
        val winningNumbers = WinningNumbers(listOf(1, 2, 3, 4, 5, 6), 7)

        // When
        val result = Result(tickets, winningNumbers)

        // Then
        assertThat(result.getResultCount(Rank.FIRST)).isEqualTo(1)
        assertThat(result.getResultCount(Rank.SECOND)).isEqualTo(1)
        assertThat(result.getResultCount(Rank.THIRD)).isEqualTo(1)
        assertThat(result.getResultCount(Rank.FOURTH)).isEqualTo(1)
        assertThat(result.getResultCount(Rank.FIFTH)).isEqualTo(1)
    }
}