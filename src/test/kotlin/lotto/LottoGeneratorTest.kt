package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoGeneratorTest {
    @Test
    fun `generates exactly six numbers`() {
        val lotto = LottoGenerator.generateLotto()
        assertThat(lotto.getNumbers().size).isEqualTo(6)
    }

    @Test
    fun `generated lotto numbers are unique`() {
        val lotto = LottoGenerator.generateLotto()
        assertThat(lotto.getNumbers().toSet().size).isEqualTo(6)
    }

    @Test
    fun `generated lotto numbers are between 1 and 45`() {
        val lotto = LottoGenerator.generateLotto()
        assertThat(lotto.getNumbers().all { it in 1..45 }).isTrue()
    }
}