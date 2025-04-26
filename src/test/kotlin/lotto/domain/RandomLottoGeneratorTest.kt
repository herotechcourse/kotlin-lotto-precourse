package lotto.domain

import lotto.util.Constants
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test

class RandomLottoGeneratorTest {

    private val generator = RandomLottoGenerator()

    @Test
    fun `generate method should generate six unique numbers`() {
        val numbers = generator.generate()
        assertThat(numbers).hasSize(Constants.LOTTO_NUMBER_COUNT)
        assertThat(numbers.toSet()).hasSize(Constants.LOTTO_NUMBER_COUNT)
    }

    @Test
    fun `generate method should generate numbers between 1 and 45`() {
        val numbers = generator.generate()
        assertThat(numbers).allMatch { it in Constants.MIN_LOTTO_NUMBER..Constants.MAX_LOTTO_NUMBER }
    }

    @Test
    fun `generate method should generate numbers in ascending order`() {
        val numbers = generator.generate()
        val sortedNumbers = numbers.sorted()
        assertThat(numbers).isEqualTo(sortedNumbers)
    }
}