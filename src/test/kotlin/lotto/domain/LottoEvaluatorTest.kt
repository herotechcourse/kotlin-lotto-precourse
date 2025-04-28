package lotto.domain

import lotto.Lotto
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoEvaluatorTest {

	@Test
	fun `should return correct rank counts when evaluating lottos`() {

		val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
		val bonusNumber = 7

		val lottoList = listOf(
			Lotto(listOf(1, 2, 3, 4, 5, 6)),
			Lotto(listOf(1, 2, 3, 4, 5, 7)),
			Lotto(listOf(1, 2, 3, 4, 5, 8)),
			Lotto(listOf(1, 2, 3, 4, 7, 8)),
			Lotto(listOf(1, 2, 3, 7, 8, 9)),
			Lotto(listOf(10, 11, 12, 13, 14, 15))
		)

		val result = LottoEvaluator.evaluate(lottoList, winningNumbers, bonusNumber)

		assertThat(result[Rank.FIRST]).isEqualTo(1)
		assertThat(result[Rank.SECOND]).isEqualTo(1)
		assertThat(result[Rank.THIRD]).isEqualTo(1)
		assertThat(result[Rank.FOURTH]).isEqualTo(1)
		assertThat(result[Rank.FIFTH]).isEqualTo(1)
		assertThat(result[Rank.NONE]).isEqualTo(1)
	}

	@Test
	fun `should return empty map when lotto list is empty`() {

		val emptyLottoList = emptyList<Lotto>()
		val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
		val bonusNumber = 7

		val result = LottoEvaluator.evaluate(emptyLottoList, winningNumbers, bonusNumber)
		assertThat(result).isEmpty()
	}
}