package lotto

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class LottoManagerTest {

    private lateinit var lottoManager: LottoManager

    @BeforeEach
    fun setup() {
        lottoManager = LottoManager()
    }

    @Test
    fun `validatePurchaseAmount should throw exception when amount is not divisible by 1000`() {
        assertThatThrownBy { lottoManager.validatePurchaseAmount(1500) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("multiple of 1000")
    }

    @Test
    fun `validatePurchaseAmount should throw exception when amount is zero or negative`() {
        assertThatThrownBy { lottoManager.validatePurchaseAmount(0) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("greater than 0")

        assertThatThrownBy { lottoManager.validatePurchaseAmount(-1000) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("greater than 0")
    }

    @Test
    fun `generateTickets should create correct number of tickets based on amount`() {
        val tickets1 = lottoManager.generateTickets(1000)
        val tickets5 = lottoManager.generateTickets(5000)

        assertThat(tickets1).hasSize(1)
        assertThat(tickets5).hasSize(5)
    }

    @Test
    fun `generateTickets should create valid lotto tickets`() {
        val tickets = lottoManager.generateTickets(3000)

        tickets.forEach { ticket ->
            assertThat(ticket.getNumbers()).hasSize(6)
            assertThat(ticket.getNumbers()).doesNotHaveDuplicates()
            assertThat(ticket.getNumbers()).allMatch { it in 1..45 }
            assertThat(ticket.getNumbers()).isSorted()
        }
    }

    @Test
    fun `validateWinningNumbers should throw exception when not exactly 6 numbers`() {
        assertThatThrownBy { lottoManager.validateWinningNumbers(listOf(1, 2, 3, 4, 5)) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("exactly 6 numbers")

        assertThatThrownBy { lottoManager.validateWinningNumbers(listOf(1, 2, 3, 4, 5, 6, 7)) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("exactly 6 numbers")
    }

    @Test
    fun `validateWinningNumbers should throw exception when numbers are not unique`() {
        assertThatThrownBy { lottoManager.validateWinningNumbers(listOf(1, 2, 3, 4, 5, 5)) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("unique")
    }

    @Test
    fun `validateWinningNumbers should throw exception when numbers are out of range`() {
        assertThatThrownBy { lottoManager.validateWinningNumbers(listOf(0, 1, 2, 3, 4, 5)) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("between 1 and 45")

        assertThatThrownBy { lottoManager.validateWinningNumbers(listOf(1, 2, 3, 4, 5, 46)) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("between 1 and 45")
    }

    @Test
    fun `validateBonusNumber should throw exception when bonus number is out of range`() {
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)

        assertThatThrownBy { lottoManager.validateBonusNumber(0, winningNumbers) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("between 1 and 45")

        assertThatThrownBy { lottoManager.validateBonusNumber(46, winningNumbers) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("between 1 and 45")
    }

    @Test
    fun `validateBonusNumber should throw exception when bonus number is in winning numbers`() {
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)

        assertThatThrownBy { lottoManager.validateBonusNumber(3, winningNumbers) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("not be among the winning numbers")
    }

    @Test
    fun `validateBonusNumber should accept valid bonus number`() {
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)

        lottoManager.validateBonusNumber(7, winningNumbers)
    }
}