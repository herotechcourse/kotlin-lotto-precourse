package lotto.domain

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

}
