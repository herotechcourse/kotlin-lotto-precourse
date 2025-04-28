package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoGeneratorTest {
    @Test
    fun `generate correct number of lotto tickets`() {
        val ticketCount = 5
        val lottos = LottoGenerator.generate(ticketCount)

        assertThat(lottos.tickets.size).isEqualTo(ticketCount)
    }
}