package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoResultTest {

    @Test
    fun `3 numbers matched results in 5th place`() {
        val tickets = listOf(Lotto(listOf(1, 2, 3, 10, 11, 12)))
        val result = LottoResult().calculateStatics(listOf(1, 2, 3, 4, 5, 6), 7, tickets)

        assertThat(result[0]).isEqualTo(1)
    }

    @Test
    fun `5 numbers and bonus matched results in 2nd place`() {
        val tickets = listOf(Lotto(listOf(1, 2, 3, 4, 5, 7)))
        val result = LottoResult().calculateStatics(listOf(1, 2, 3, 4, 5, 6), 7, tickets)

        assertThat(result[3]).isEqualTo(1)
    }

    @Test
    fun `6 numbers matched results in 1st place`() {
        val tickets = listOf(Lotto(listOf(1, 2, 3, 4, 5, 6)))
        val result = LottoResult().calculateStatics(listOf(1, 2, 3, 4, 5, 6), 7, tickets)

        assertThat(result[4]).isEqualTo(1)
    }

    @Test
    fun `profit rate is correctly calculated`() {
        val tickets = listOf(Lotto(listOf(1, 2, 3, 4, 5, 6)))
        val result = LottoResult().calculateStatics(listOf(1, 2, 3, 4, 5, 6), 7, tickets)
        val totalRate = LottoResult().calculateTotal(result, 1000)

        assertThat(totalRate).isEqualTo(200000000.0)
    }
}