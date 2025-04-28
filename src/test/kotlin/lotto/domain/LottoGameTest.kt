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
}
