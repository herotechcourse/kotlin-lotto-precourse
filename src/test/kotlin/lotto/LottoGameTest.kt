package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.BeforeEach
import org.assertj.core.api.Assertions.assertThat

class LottoGameTest {
    private lateinit var game: LottoGame
    private val purchaseAmount = 5000u
    private val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
    private val bonusNumber = 7
    private val numberOfTickets = 5

    @BeforeEach
    fun setUp() {
        game = LottoGame(purchaseAmount, winningNumbers, bonusNumber, numberOfTickets)
    }

    @Test
    fun `constructor initializes fields correctly`() {
        assertThat(game.purchaseAmount).isEqualTo(purchaseAmount)
        assertThat(game.winningNumbers).isEqualTo(winningNumbers)
        assertThat(game.bonusNumber).isEqualTo(bonusNumber)
        assertThat(game.numberOfTickets).isEqualTo(numberOfTickets)
    }

    @Test
    fun `created tickets contain unique numbers between 1 and 45`() {
        val tickets = game.getTickets()

        tickets.forEach { ticket ->
            val numbers = ticket.getNumbers()
            assertThat(numbers.size).isEqualTo(6)
            assertThat(numbers.toSet().size).isEqualTo(6)
            assertThat(numbers.all { it in 1..45 }).isTrue()
        }
    }

    @Test
    fun `createMultipleTickets creates correct number of tickets`() {
        assertThat(game.getTickets().size).isEqualTo(numberOfTickets)
    }
}
