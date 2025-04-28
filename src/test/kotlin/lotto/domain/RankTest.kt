package lotto.domain

import lotto.error.UnexpectedException
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class RankTest {

	@Test
	fun `should return correct Rank based on match count and bonus`() {
		assertThat(Rank.from(6, bonusMatched = false)).isEqualTo(Rank.FIRST)
		assertThat(Rank.from(5, bonusMatched = true)).isEqualTo(Rank.SECOND)
		assertThat(Rank.from(5, bonusMatched = false)).isEqualTo(Rank.THIRD)
		assertThat(Rank.from(4, bonusMatched = false)).isEqualTo(Rank.FOURTH)
		assertThat(Rank.from(3, bonusMatched = false)).isEqualTo(Rank.FIFTH)
		assertThat(Rank.from(2, bonusMatched = false)).isEqualTo(Rank.NONE)
	}

	@Test
	fun `should throw UnexpectedException on invalid match count`() {
		assertThrows<UnexpectedException> {
			Rank.from(10, bonusMatched = false)
		}
	}
}