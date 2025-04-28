package lotto

import lotto.common.Constants
import lotto.generator.LottoGenerator
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class RandomNumberTest {
    @Test
    fun `should contain numbers only within the range 1 to 45`() {
        // given
        val lotto: Lotto = LottoGenerator.generate()

        // when
        val numbers = lotto.toString().replace("[", "").replace("]", "").split(",").map { it.trim().toInt() }

        // then
        assertThat(numbers).allMatch { it in Constants.MIN_LOTTO_NUMBER..Constants.MAX_LOTTO_NUMBER }

    }

    @Test
    fun `should contain exactly 6 numbers`() {
        // given
        val lotto: Lotto = LottoGenerator.generate()

        // when
        val numbers = lotto.toString().replace("[", "").replace("]", "").split(",").map { it.trim().toInt() }

        // then
        assertThat(numbers).hasSize(6)
    }

    @Test
    fun `should not contain duplicate numbers`() {
        // given
        val lotto = LottoGenerator.generate()

        // when
        val numbers = lotto.toString().replace("[", "").replace("]", "").split(",").map { it.trim().toInt() }

        // then
        assertThat(numbers.distinct().size).isEqualTo(numbers.size)
    }
}