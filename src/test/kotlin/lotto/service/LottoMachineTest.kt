package lotto.service

import lotto.Lotto
import lotto.domain.LottoNumberGenerator
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test

class LottoMachineTest {
    private class TestLottoNumberGenerator : LottoNumberGenerator {
        override fun generate(): List<Int> {
            return listOf(1, 2, 3, 4, 5, 6)
        }
    }

    @Test
    fun `issueTicket should issue correct number of tickets based on purchaseAmount`() {
        val lottoMachine = LottoMachine(TestLottoNumberGenerator())
        val purchasedLottos = lottoMachine.issueTickets(3000)

        assertThat(purchasedLottos.count()).isEqualTo(3)
    }

    @Test
    fun `issueTickets should issue tickets with expected lotto numbers`() {
        val lottoMachine = LottoMachine(TestLottoNumberGenerator())
        val purchasedLottos = lottoMachine.issueTickets(2000)

        assertThat(purchasedLottos.getAllTickets())
            .allSatisfy{ticket ->
                assertThat(ticket).isEqualTo(Lotto(listOf(1, 2, 3, 4, 5, 6)))
            }
    }
}