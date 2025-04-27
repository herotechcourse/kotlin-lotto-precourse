package lotto.model

import lotto.Lotto
import lotto.model.generator.LottoNumberGenerator
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoBundleTest {
    private class FakeLottoNumberGenerator(private val numbers: List<Int>) : LottoNumberGenerator {
        override fun generate(): List<Int> = numbers
    }

    @Test
    fun `creates LottoBundle correctly from purchase amount`() {
        val purchaseAmount = LottoPurchaseAmount(2000) // 2개 구매
        val generator = FakeLottoNumberGenerator(listOf(1, 2, 3, 4, 5, 6))

        val bundle = LottoBundle.from(purchaseAmount, generator)

        assertThat(bundle.allLottoNumbers().size).isEqualTo(2)
        assertThat(bundle.allLottoNumbers()).allMatch { it == listOf(1, 2, 3, 4, 5, 6) }
    }

    @Test
    fun `returns correct MatchResults`() {
        val lottos = listOf(
            Lotto(listOf(1, 2, 3, 4, 5, 6)),
            Lotto(listOf(1, 2, 3, 7, 8, 9))
        )
        val bundle = LottoBundle(lottos, FakeLottoNumberGenerator(emptyList()))

        val winningLotto = WinningLotto(Lotto(listOf(1, 2, 3, 4, 5, 6)), bonusNumber = 7)
        val matchResults = bundle.matchResults(winningLotto)

        assertThat(matchResults.countOf(MatchRank.FIRST)).isEqualTo(1) // 6개 일치
        assertThat(matchResults.countOf(MatchRank.FIFTH)).isEqualTo(1) // 3개 일치
    }

    @Test
    fun `returns all lotto numbers correctly`() {
        val lottos = listOf(
            Lotto(listOf(1, 2, 3, 4, 5, 6)),
            Lotto(listOf(7, 8, 9, 10, 11, 12))
        )
        val bundle = LottoBundle(lottos, FakeLottoNumberGenerator(emptyList()))

        val allNumbers = bundle.allLottoNumbers()

        assertThat(allNumbers).containsExactly(
            listOf(1, 2, 3, 4, 5, 6),
            listOf(7, 8, 9, 10, 11, 12)
        )
    }
}
