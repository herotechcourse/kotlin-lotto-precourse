package lotto.domain

import camp.nextstep.edu.missionutils.test.NsTest
import lotto.Lotto
import lotto.error.PurchaseError
import lotto.error.UnexpectedException
import lotto.error.toMessage
import lotto.main
import lotto.service.GameResult
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class DomainBusinessTest : NsTest() {

	@Test
	fun `should issue correct number of lotto tickets based on amount`() {
		val issuer = LottoIssuer(8000)
		val tickets = issuer.issue()

		assertThat(tickets).hasSize(8)
	}

	@Test
	fun `should display error when amount is below ticket price`() {
		run("500")
		assertThat(output()).contains(PurchaseError.CANNOT_AFFORD_TICKET.toMessage())
	}

	@Test
	fun `should return correct rank from matched count and bonus`() {
		assertThat(Rank.from(6, false)).isEqualTo(Rank.FIRST)
		assertThat(Rank.from(5, true)).isEqualTo(Rank.SECOND)
		assertThat(Rank.from(5, false)).isEqualTo(Rank.THIRD)
		assertThat(Rank.from(4, false)).isEqualTo(Rank.FOURTH)
		assertThat(Rank.from(3, false)).isEqualTo(Rank.FIFTH)
		assertThat(Rank.from(2, false)).isEqualTo(Rank.NONE)
	}

	@Test
	fun `Rank_from should throw exception for invalid match count`() {
		assertThrows<UnexpectedException> {
			Rank.from(7, bonusMatched = false)
		}
	}


	@Test
	fun `should correctly calculate profit rate`() {
		val result = GameResult(
			lottoList = listOf(
				Lotto(listOf(1, 2, 3, 4, 5, 6)),
				Lotto(listOf(1, 2, 3, 4, 5, 7)),
				Lotto(listOf(1, 2, 3, 4, 5, 8)),
				Lotto(listOf(10, 11, 12, 13, 14, 15)),
			),
			winningNumbers = listOf(1, 2, 3, 4, 5, 6),
			bonusNumber = 7,
			amount = 4000L,
		)

		val profitRate = result.calculateProfitRate()
		
		assertThat(profitRate).isGreaterThan(100.0)
	}

	override fun runMain() {
		main()
	}
}