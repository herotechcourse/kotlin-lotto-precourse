package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoesGeneratorTest {

    @Test
    fun `generate correct number of lottoes based on amount`() {

        val amount = 8000
        val lottoes = LottoesGenerator.generate(amount)
        assertThat(lottoes.size()).isEqualTo(8)
    }
}