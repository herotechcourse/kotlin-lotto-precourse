package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoServiceTest {
    @Test
    fun `should generate correct number of lotto tickets based on purchase amount`() {
        val purchaseAmount = 8000
        val lottos = LottoService.generateLottos(purchaseAmount)

        assertThat(lottos).hasSize(8)
    }

    @Test
    fun `should generate lotto tickets with six unique numbers between 1 and 45`() {
        val purchaseAmount = 1000
        val lottos = LottoService.generateLottos(purchaseAmount)

        val numbers = lottos.first().getNumbers()

        assertThat(numbers).hasSize(6)
        assertThat(numbers.toSet()).hasSize(6) // 중복이 없는지
        assertThat(numbers).allMatch { it in 1..45 }
    }
}
