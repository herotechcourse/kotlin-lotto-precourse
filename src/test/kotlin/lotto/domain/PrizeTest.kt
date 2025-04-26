package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PrizeTest {

    @Test
    fun `valuesForResult returns prizes in correct order`() {
        // when
        val prizes = Prize.valuesForResult()

        // then
        assertThat(prizes).containsExactly(
            Prize.FIFTH,
            Prize.FOURTH,
            Prize.THIRD,
            Prize.SECOND,
            Prize.FIRST
        )
    }

    @Test
    fun `each prize has correct amount and description`() {
        // then
        assertThat(Prize.FIRST.amount).isEqualTo(2_000_000_000)
        assertThat(Prize.FIRST.description).isEqualTo(PrizeDescription.FIRST)

        assertThat(Prize.SECOND.amount).isEqualTo(30_000_000)
        assertThat(Prize.SECOND.description).isEqualTo(PrizeDescription.SECOND)

        assertThat(Prize.THIRD.amount).isEqualTo(1_500_000)
        assertThat(Prize.THIRD.description).isEqualTo(PrizeDescription.THIRD)

        assertThat(Prize.FOURTH.amount).isEqualTo(50_000)
        assertThat(Prize.FOURTH.description).isEqualTo(PrizeDescription.FOURTH)

        assertThat(Prize.FIFTH.amount).isEqualTo(5_000)
        assertThat(Prize.FIFTH.description).isEqualTo(PrizeDescription.FIFTH)

        assertThat(Prize.NONE.amount).isEqualTo(0)
        assertThat(Prize.NONE.description).isEqualTo(PrizeDescription.NONE)
    }
}
