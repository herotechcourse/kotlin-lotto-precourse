package lotto.domain

import lotto.Lotto
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
}
