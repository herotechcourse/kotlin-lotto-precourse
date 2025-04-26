package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.RepeatedTest

class RandomNumberGeneratorTest {

    private val generator = RandomNumberGenerator()

    @RepeatedTest(10)
    fun `generate returns 6 unique numbers within valid range`() {
        val numbers = generator.generate()

        assertThat(numbers).hasSize(RandomNumberGenerator.NUMBER_COUNT)
        assertThat(numbers.toSet()).hasSize(RandomNumberGenerator.NUMBER_COUNT)
        assertThat(numbers).allMatch { it in RandomNumberGenerator.MIN_NUMBER..RandomNumberGenerator.MAX_NUMBER }
    }
}
