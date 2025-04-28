package lotto

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat

class LottoGeneratorTest {
    @Test
    fun `returns a valid lotto with six numbers within range`() {
        val lotto = generateLotto()
        assertThat(lotto.getNumbers())
            .hasSize(6)
            .allMatch { it in 1..45 }
    }

    @Test
    fun `generates correct number of lotto tickets`() {
        val lottos = generateLottos(5)
        assertThat(lottos).hasSize(5)
        lottos.forEach { assertThat(it.getNumbers()).hasSize(6) }
    }
}