package lotto.domain

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test

class RandomLottoGeneratorTest {

    private val generator = RandomLottoGenerator()

    @Test
    fun `generate method should generate six unique numbers`() {
        val numbers = generator.generate()
        assertThat(numbers).hasSize(6)
        assertThat(numbers.toSet()).hasSize(6)
    }

    @Test
    fun `generate method should generate numbers between 1 and 45`() {
        val numbers = generator.generate()
        assertThat(numbers).allMatch { it in 1..45 }
    }

    @Test
    fun `generate method should generate numbers in ascending order`() {
        val numbers = generator.generate()
        val sortedNumbers = numbers.sorted()
        assertThat(numbers).isEqualTo(sortedNumbers)
    }
}