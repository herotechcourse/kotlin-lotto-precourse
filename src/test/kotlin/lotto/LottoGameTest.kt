package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoGameTest {
    @Test
    fun `calculate match count correctly`() {
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val ticket = Lotto(listOf(1, 2, 7, 8, 9, 10))

        val matchCount = winningNumbers.count { it in ticket.getNumbers() }

        assertThat(matchCount).isEqualTo(2)
    }

    @Test
    fun `calculate profit rate correctly`() {
        val totalAmount = 8000
        val totalWinnings = 5000

        val profitRate = (totalWinnings.toDouble() / totalAmount) * 100

        assertThat(profitRate).isEqualTo(62.5)
    }
}
