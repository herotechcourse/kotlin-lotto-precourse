package lotto

import lotto.domain.Rank
import lotto.domain.WinningNumbers
import lotto.service.LottoService
import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat

class LottoServiceTest {
    @Test
    fun `purchaseLottos returns correct number of lottos`() {
        // Given
        val lottoService = LottoService()
        val amount = 3000

        // When
        val lottos = lottoService.purchaseLottos(amount)

        // Then
        assertThat(lottos).hasSize(3)
    }

    @Test
    fun `calculateResults returns correct distribution of ranks`() {
        // Given
        val lottoService = LottoService()
        val lotto1 = Lotto(listOf(1, 2, 3, 4, 5, 6)) // 6 matches - FIFTH
        val lotto2 = Lotto(listOf(1, 2, 3, 4, 5, 7)) // 5 matches + bonus - FOURTH
        val lotto3 = Lotto(listOf(1, 2, 3, 4, 5, 8)) // 5 matches - THIRD
        val lotto4 = Lotto(listOf(1, 2, 3, 4, 9, 10)) // 4 matches - SECOND
        val lotto5 = Lotto(listOf(1, 2, 3, 9, 10, 11)) // 3 matches - FIRST
        val lotto6 = Lotto(listOf(1, 2, 8, 9, 10, 11)) // 2 matches - NONE

        val lottos = listOf(lotto1, lotto2, lotto3, lotto4, lotto5, lotto6)
        val winningNumbers = WinningNumbers(listOf(1, 2, 3, 4, 5, 6), 7)

        // When
        val results = lottoService.calculateResults(lottos, winningNumbers)

        // Then
        assertThat(results[Rank.FIFTH]).isEqualTo(1)
        assertThat(results[Rank.FOURTH]).isEqualTo(1)
        assertThat(results[Rank.THIRD]).isEqualTo(1)
        assertThat(results[Rank.SECOND]).isEqualTo(1)
        assertThat(results[Rank.FIRST]).isEqualTo(1)
        assertThat(results[Rank.NONE]).isEqualTo(1)
    }
}