package lotto

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows

class LottoTest {
	@Test
	fun `throws an exception when lotto numbers exceed six`() {
		assertThrows<IllegalArgumentException> {
			Lotto(listOf(1, 2, 3, 4, 5, 6, 7))
		}
	}

	@Test
	fun `throws an exception when lotto numbers contain duplicates`() {
		assertThrows<IllegalArgumentException> {
			Lotto(listOf(1, 2, 3, 4, 5, 5))
		}
	}

	@Test
	fun `creates lotto successfully with valid numbers`() {
		assertDoesNotThrow {
			Lotto(listOf(1, 2, 3, 4, 5, 6))
		}
	}

	@Test
	fun `throws an exception when lotto numbers are less than six`() {
		assertThrows<IllegalArgumentException> {
			Lotto(listOf(1, 2, 3, 4, 5)) // 5개
		}
	}

	@Test
	fun `throws an exception when lotto numbers are out of valid range`() {
		assertThrows<IllegalArgumentException> {
			Lotto(listOf(0, 1, 2, 3, 4, 5))
		}
		assertThrows<IllegalArgumentException> {
			Lotto(listOf(1, 2, 3, 4, 5, 46))
		}
	}

	@Test
	fun `throws an exception when lotto numbers have multiple duplicates`() {
		assertThrows<IllegalArgumentException> {
			Lotto(listOf(2, 2, 2, 2, 2, 2))
		}
	}

	@Test
	fun `countMatched should return correct number of matching winning numbers`() {
		val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
		val winningNumbers = listOf(1, 2, 7, 8, 9, 10)

		val matchedCount = lotto.countMatched(winningNumbers)
		assertEquals(2, matchedCount)
	}

	@Test
	fun `contains should return true if bonus number is included`() {

		val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
		val bonusNumber = 6

		val result = lotto.contains(bonusNumber)
		assertTrue(result)
	}

	@Test
	fun `contains should return false if bonus number is not included`() {
		val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
		val bonusNumber = 10

		val result = lotto.contains(bonusNumber)
		assertFalse(result)
	}
}
