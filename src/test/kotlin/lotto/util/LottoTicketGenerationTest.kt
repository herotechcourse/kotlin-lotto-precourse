package lotto.util

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test


class LottoTicketGenerationTest{

    @Test
    fun `feature test ticket generation`() {

        assertRandomUniqueNumbersInRangeTest(
            {
                val lottoTickets = LottoTicketGeneration.generateTicket(2)
                assertThat(lottoTickets[0].getTicket()).isEqualTo(listOf(1, 2, 3, 4, 5, 6))
                assertThat(lottoTickets[1].getTicket()).isEqualTo(listOf(10, 11, 12, 13, 14, 15))
            },
            listOf(1, 3, 2, 4, 5, 6),
            listOf(10, 11, 12, 13, 14, 15),
        )
    }

}