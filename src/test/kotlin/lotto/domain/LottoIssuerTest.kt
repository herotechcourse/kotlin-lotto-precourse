package lotto.domain

import lotto.Lotto
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoTest {

	@Test
	fun `should throw error when lotto numbers exceed six`() {
		assertThrows<IllegalArgumentException> {
			Lotto(listOf(1, 2, 3, 4, 5, 6, 7))
		}
	}

	@Test
	fun `should throw error when lotto numbers contain duplicates`() {
		assertThrows<IllegalArgumentException> {
			Lotto(listOf(1, 2, 3, 4, 5, 5))
		}
	}

	@Test
	fun `should throw error when lotto numbers are out of valid range`() {
		assertThrows<IllegalArgumentException> {
			Lotto(listOf(0, 2, 3, 4, 5, 6))
		}
	}

	@Test
	fun `countMatched returns correct count of matching numbers`() {

		val lotto = Lotto(listOf(1, 2, 3, 10, 20, 30))
		val winningNumbers = listOf(1, 2, 3, 4, 5, 6)

		val matchedCount = lotto.countMatched(winningNumbers)
		assertThat(matchedCount).isEqualTo(3)
	}

	@Test
	fun `contains returns true if bonus number is in lotto`() {
		val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
		assertThat(lotto.contains(5)).isTrue
	}

	@Test
	fun `contains returns false if bonus number is not in lotto`() {
		val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
		assertThat(lotto.contains(7)).isFalse
	}

	@Test
	fun `should throw exception if numbers are not sorted`() {
		assertThrows<IllegalArgumentException> {
			Lotto(listOf(6, 1, 5, 2, 4, 3))
		}
	}
}