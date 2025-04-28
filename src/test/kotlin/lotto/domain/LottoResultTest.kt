package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoResultTest {
    private val winning = setOf(1,2,3,4,5,6)
    private val bonus = 7

    @Test
    fun `3 matches return FIFTH`() {
        val ticket = LottoTicket(listOf(1,2,3,10,11,12))
        assertThat(LottoResult.of(ticket, winning, bonus))
            .isEqualTo(LottoResult.FIFTH)
    }

    @Test
    fun `5 match + bonus return SECOND`() {
        val ticket = LottoTicket(listOf(1,2,3,4,5,7))
        assertThat(LottoResult.of(ticket, winning, bonus))
            .isEqualTo(LottoResult.SECOND)
    }
    @Test
    fun `6 match returns FIRST`() {
        val ticket = LottoTicket(listOf(1,2,3,4,5,6))
        assertThat(LottoResult.of(ticket, winning, bonus))
            .isEqualTo(LottoResult.FIRST)
    }
}
