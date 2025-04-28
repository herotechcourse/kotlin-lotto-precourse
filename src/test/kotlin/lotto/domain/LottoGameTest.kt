package lotto.domain

import lotto.Lotto
import lotto.model.LottoMatchCount
import lotto.model.LottoMatchResult
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoGameTest {
    private val lottoGame = LottoGame()

    @Test
    fun `calculate the number of lotto tickets`() {
        val amount = 8000
        val quantity = lottoGame.getQuantity(amount)

        assertThat(quantity).isEqualTo(8)
    }

    @Test
    fun `issue the lotto tickets`() {
        val quantity = 5
        val lottos = lottoGame.issueLottoTickets(quantity)

        assertThat(lottos).hasSize(quantity)
        lottos.forEach { lotto ->
            assertThat(lotto.getNumbers()).hasSize(6)
            assertThat(lotto.getNumbers()).allSatisfy { number ->
                assertThat(number).isBetween(1, 45)
            }
            assertThat(lotto.getNumbers().toSet().size).isEqualTo(6)
        }
    }

    @Test
    fun `calculate the match result for each lotto ticket`() {
        val lottos = listOf(
            Lotto(listOf(1, 2, 3, 4, 5, 6)),
            Lotto(listOf(6, 7, 8, 9, 10, 11))
        )
        val winningNumbers = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val bonusNumber = 7

        val results = lottoGame.result(lottos, winningNumbers, bonusNumber)

        assertThat(results[0].matchedCount).isEqualTo(6)
        assertThat(results[0].hasBonus).isFalse()
        assertThat(results[1].matchedCount).isEqualTo(1)
        assertThat(results[1].hasBonus).isTrue()
    }

    @Test
    fun `aggregate match results into a LottoMatchResult`() {
        val matchCounts = listOf(
            LottoMatchCount(matchedCount = 6, hasBonus = false),
            LottoMatchCount(matchedCount = 5, hasBonus = true),
            LottoMatchCount(matchedCount = 5, hasBonus = false),
            LottoMatchCount(matchedCount = 4, hasBonus = false),
            LottoMatchCount(matchedCount = 3, hasBonus = false),
            LottoMatchCount(matchedCount = 2, hasBonus = false)
        )

        val result = lottoGame.match(matchCounts)

        assertThat(result.sixMatching).isEqualTo(1)
        assertThat(result.fiveMatchingWithBonus).isEqualTo(1)
        assertThat(result.fiveMatching).isEqualTo(1)
        assertThat(result.fourMatching).isEqualTo(1)
        assertThat(result.threeMatching).isEqualTo(1)
    }

    @Test
    fun `calculate the rate`() {
        val purchaseAmount = 2000
        val lottoMatchResult = LottoMatchResult(
            sixMatching = 0,
            fiveMatchingWithBonus = 0,
            fiveMatching = 0,
            fourMatching = 0,
            threeMatching = 1
        )

        val rate = lottoGame.calculateRate(lottoMatchResult, purchaseAmount)

        assertThat(rate).isEqualTo(250.0f)
    }
}
