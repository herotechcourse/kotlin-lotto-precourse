package lotto.util

import lotto.domain.PrizeResult
import lotto.domain.Rank
import lotto.Lotto
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CalculateAndFormatReturnRateTest {

    @Test
    fun `returns 250 point 0 percent when profit is 5000 and purchase is 2000`() {
        val prizeResult = PrizeResult().apply { add(Rank.FIFTH) }
        val tickets = List(2) { Lotto(listOf(1, 2, 3, 4, 5, 6)) }

        val result = calculateAndFormatReturnRate(prizeResult, tickets)

        assertThat(result).isEqualTo("250.0")
    }

    @Test
    fun `returns 100 point 0 percent when profit equals purchase`() {
        val prizeResult = PrizeResult().apply { repeat(2) { add(Rank.FIFTH) } }
        val tickets = List(10) { Lotto(listOf(7, 8, 9, 10, 11, 12)) }

        val result = calculateAndFormatReturnRate(prizeResult, tickets)

        assertThat(result).isEqualTo("100.0")
    }

    @Test
    fun `returns 0 point 0 percent when no profit`() {
        val prizeResult = PrizeResult()
        val tickets = List(2) { Lotto(listOf(13, 14, 15, 16, 17, 18)) }

        val result = calculateAndFormatReturnRate(prizeResult, tickets)

        assertThat(result).isEqualTo("0.0")
    }
}
