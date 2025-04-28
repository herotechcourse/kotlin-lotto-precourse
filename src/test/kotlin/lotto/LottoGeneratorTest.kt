package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoGeneratorTest {
    @Test
    fun `creates correct number of lottos`() {
        val count = 5
        val lottos = LottoGenerator.generateLottos(count)

        assertThat(lottos).hasSize(count)
    }

    @Test
    fun `each lotto has six unique numbers`() {
        val count = 5
        val lottos = LottoGenerator.generateLottos(count)

        lottos.forEach {
            val numbers = it.getNumbers()
            assertThat(numbers).hasSize(6)
            assertThat(numbers.toSet().size).isEqualTo(6)
        }
    }

    @Test
    fun `each number of lotto is in range 1 to 45`() {
        val count = 5
        val lottos = LottoGenerator.generateLottos(count)

        lottos.flatMap { it.getNumbers() }
            .forEach { assertThat(it).isBetween(1, 45) }
    }

    @Test
    fun `each lotto numbers are sorted in ascending order`() {
        val count = 5
        val lottos = LottoGenerator.generateLottos(count)

        lottos.forEach {
            val numbers = it.getNumbers()
            assertThat(numbers).isSorted()
        }
    }
}