package lotto

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test

class LottosTest {
    @Test
    fun `getTickets return a copy of the original numbers`() {
        val original = listOf(1,2,3,4,5,6)
        val lotto = Lotto(original)
        val originalLottos = mutableListOf<Lotto>()
        for (i in 1..3) {
            originalLottos.add(lotto)
        }
        val lottos = Lottos(originalLottos)
        val tickets = lottos.getTickets()

        assertThat(tickets).isNotSameAs(originalLottos)
    }
}