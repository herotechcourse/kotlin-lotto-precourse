package lotto.lottogenerator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.RepeatedTest
import org.junit.jupiter.api.assertAll

class RandomLottoGeneratorTest {

    @RepeatedTest(5)
    fun `should generate lotto numbers within range`() {
        // given
        val randomLottoGenerator = RandomLottoGenerator()
        // when
        val lotto = randomLottoGenerator.generate()
        // then
        assertAll(
            { assertThat(lotto.numbers()).hasSize(6) },
            { assertThat(lotto.numbers()).allMatch { it in MIN_INCLUSIVE..MAX_INCLUSIVE } }
        )
    }

    companion object {
        private const val MIN_INCLUSIVE: Int = 1
        private const val MAX_INCLUSIVE: Int = 45
    }
}
