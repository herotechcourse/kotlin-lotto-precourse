package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoGeneratorTest {
    @Test
    fun `create lottos according to the amount`() {
        val amount = 4000
        val result = LottoGenerator.generate(amount)

        assertThat(result).hasSize(4)
    }
}