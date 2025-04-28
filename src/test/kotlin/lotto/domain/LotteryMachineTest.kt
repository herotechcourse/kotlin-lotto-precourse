package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LotteryMachineTest {
    @Test
    fun `buy with non-zero purchase amount returns correct count and valid tickets`() {
        // given
        val purchase = PurchaseAmount(5000);
        val machine = LotteryMachine()

        // when
        val lottos = machine.buy(purchase)

        // then
        assertThat(lottos).hasSize(purchase.ticketCount)
        lottos.forEach { lotto ->
            val nums = lotto.getNumbers()

            assertThat(nums).hasSize(6)
            assertThat(nums).allMatch { it in 1..45 }
            assertThat(nums.distinct()).hasSize(6)
        }
    }
}