package lotto

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test

class LottoMachineTest {
    @Test
    fun `generate the correct number of Lotto tickets with fixed numbers`() {
        // given
        val ticketCount = 7
        val fixedNumbers = listOf(1, 2, 3, 4, 5, 6)
        val stubLottoNumberGenerator = StubLottoNumberGenerator(fixedNumbers)
        val lottoMachine = LottoMachine(stubLottoNumberGenerator)

        // when
        val lottos = lottoMachine.generate(ticketCount)

        // then
        assertThat(lottos.getTickets()).hasSize(ticketCount)
        lottos.getTickets().forEach { lotto ->
            assertThat(lotto.getNumbers()).containsExactly(1, 2, 3, 4, 5, 6)
        }
    }
}