package lotto.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PrizeTierTest {

    @Test
    fun `returns FIRST prize when all 6 numbers match`() {
        val prize = PrizeTier.calculate(6, false)

        assertThat(prize).isEqualTo(PrizeTier.FIRST)
        assertThat(prize.prizeMoney).isEqualTo(2000000000L)
        assertThat(prize.description).isEqualTo("6 Matches")
    }

    @Test
    fun `returns SECOND prize when 5 numbers match and bonus number match`() {
        val prize = PrizeTier.calculate(5, true)

        assertThat(prize).isEqualTo(PrizeTier.SECOND)
        assertThat(prize.prizeMoney).isEqualTo(30000000L)
        assertThat(prize.description).isEqualTo("5 Matches + Bonus Ball")
    }

    @Test
    fun `returns THIRD prize when 5 numbers match`() {
        val prize = PrizeTier.calculate(5, false)

        assertThat(prize).isEqualTo(PrizeTier.THIRD)
        assertThat(prize.prizeMoney).isEqualTo(1500000L)
        assertThat(prize.description).isEqualTo("5 Matches")
    }

    @Test
    fun `returns FOURTH prize when 4 numbers match`() {
        val prize = PrizeTier.calculate(4, false)

        assertThat(prize).isEqualTo(PrizeTier.FOURTH)
        assertThat(prize.prizeMoney).isEqualTo(50000L)
        assertThat(prize.description).isEqualTo("4 Matches")
    }

    @Test
    fun `returns FOURTH prize when 4 numbers match and bonus number match`() {
        val prize = PrizeTier.calculate(4, true)

        assertThat(prize).isEqualTo(PrizeTier.FOURTH)
        assertThat(prize.prizeMoney).isEqualTo(50000L)
        assertThat(prize.description).isEqualTo("4 Matches")
    }

    @Test
    fun `returns FIFTH prize when 3 numbers match`() {
        val prize = PrizeTier.calculate(3, false)

        assertThat(prize).isEqualTo(PrizeTier.FIFTH)
        assertThat(prize.prizeMoney).isEqualTo(5000L)
        assertThat(prize.description).isEqualTo("3 Matches")
    }

    @Test
    fun `returns NONE prize when less than 3 numbers match`() {
        assertThat(PrizeTier.calculate(2, true)).isEqualTo(PrizeTier.NONE)
        assertThat(PrizeTier.calculate(2, false)).isEqualTo(PrizeTier.NONE)
        assertThat(PrizeTier.calculate(1, false)).isEqualTo(PrizeTier.NONE)
        assertThat(PrizeTier.calculate(0, false)).isEqualTo(PrizeTier.NONE)
    }
}