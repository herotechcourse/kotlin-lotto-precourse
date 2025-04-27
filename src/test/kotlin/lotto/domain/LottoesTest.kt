package lotto.domain

import lotto.Lotto
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoesTest {

    @Test
    fun `save lotto tickets in Lottoes`() {

        val lotto1 = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val lotto2 = Lotto(listOf(10, 11, 12, 13, 14, 15))


        val lottoes = Lottoes(listOf(lotto1, lotto2))


        assertThat(lottoes.size()).isEqualTo(2)
        assertThat(lottoes.getTickets()).containsExactly(lotto1, lotto2)
    }

    @Test
    fun `Lottoes cannot be created with an empty list`() {

        assertThrows<IllegalArgumentException> {
            Lottoes(emptyList())
        }
    }
}