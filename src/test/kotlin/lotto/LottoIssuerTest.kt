package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoIssuerTest {

    private val lottoIssuer = LottoIssuer()

    @Test
    fun `should issue correct number of lottos based on purchase amount`() {
        val purchaseAmount = 5000 // 5 tickets
        val lottos = lottoIssuer.issueLottos(purchaseAmount)

        assertThat(lottos).hasSize(5)
    }

    @Test
    fun `each issued lotto should contain exactly 6 numbers`() {
        val purchaseAmount = 3000 // 3 tickets
        val lottos = lottoIssuer.issueLottos(purchaseAmount)

        assertThat(lottos).allSatisfy { lotto ->
            assertThat(lotto.getNumbers()).hasSize(6)
        }
    }
}