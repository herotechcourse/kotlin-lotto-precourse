package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoGeneratorTest {
    @Test
    fun `generates the requested number of lottos`() {
        val count = 5
        val lottos = LottoGenerator.createRandomLottos(count)
        assertThat(lottos).hasSize(count)
    }

    @Test
    fun `generates 6 unique numbers`() {
        val count = 10
        val lottos = LottoGenerator.createRandomLottos(count)

        for (lotto in lottos) {
            val numbers = lotto.getNumbers()
            assertThat(numbers).hasSize(6)
            assertThat(numbers.toSet().size).isEqualTo(6)
            assertThat(numbers).allMatch { it in 1..45 }
        }
    }
}