package lotto.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoNumberMakerTest {
    @Test
    fun `lotto number should contain 6 unique numbers from 1 to 45`() {
        val lottoTicket = LottoNumberMaker.makeLottoTicket()

        assertThat(lottoTicket.getNumbers())
            .hasSize(6)
            .doesNotHaveDuplicates()
            .allSatisfy { number ->
                assertThat(number)
                    .isBetween(1, 45)
            }
    }

    @Test
    fun `number of totalLottoNumberList should return a list with size matching ticketCount`() {
        val ticketCount = 3

        val totalLottoNumber = LottoNumberMaker.makeTotalLottoTicket(ticketCount)
        assertThat(totalLottoNumber).hasSize(ticketCount)
    }
}
