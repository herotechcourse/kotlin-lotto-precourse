package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class LottoResultTest {

    private lateinit var lottoResult: LottoResult

    @BeforeEach
    fun setup() {
        lottoResult = LottoResult()
    }

    @Test
    fun `records FIFTH prize when 3 numbers match`() {
        val ticket = Lotto(listOf(1, 2, 3, 7, 8, 9))
        val winningNumbers = listOf(1, 2, 3, 10, 11, 12)
        val bonusNumber = 7

        lottoResult.evaluateAndRecord(ticket, winningNumbers, bonusNumber)

        val stats = lottoResult.getRankStatistics()
        assertThat(stats[Rank.FIFTH]).isEqualTo(1)
    }

    @Test
    fun `records SECOND prize when 5 numbers match and bonus matches`() {
        val ticket = Lotto(listOf(1, 2, 3, 4, 5, 7))
        val winningNumbers = listOf(1, 2, 3, 4, 5, 45)
        val bonusNumber = 7

        lottoResult.evaluateAndRecord(ticket, winningNumbers, bonusNumber)

        val stats = lottoResult.getRankStatistics()
        assertThat(stats[Rank.SECOND]).isEqualTo(1)
    }

    @Test
    fun `calculates correct profit rate`() {
        val ticket = Lotto(listOf(1, 2, 3, 7, 8, 9))
        val winningNumbers = listOf(1, 2, 3, 10, 11, 12)
        val bonusNumber = 7

        lottoResult.evaluateAndRecord(ticket, winningNumbers, bonusNumber)

        val profitRate = lottoResult.getProfitRate(1000)

        assertThat(profitRate).isEqualTo(500.0)
    }

    @Test
    fun `returns correct statistics after multiple tickets evaluated`() {
        val tickets = listOf(
            Lotto(listOf(1, 2, 3, 7, 8, 9)),
            Lotto(listOf(1, 2, 3, 4, 5, 7)),
        )
        val winningNumbers = listOf(1, 2, 3, 4, 5, 45)
        val bonusNumber = 7

        tickets.forEach { lottoResult.evaluateAndRecord(it, winningNumbers, bonusNumber) }

        val stats = lottoResult.getRankStatistics()
        assertThat(stats[Rank.FIFTH]).isEqualTo(1)
        assertThat(stats[Rank.SECOND]).isEqualTo(1)
    }
}
