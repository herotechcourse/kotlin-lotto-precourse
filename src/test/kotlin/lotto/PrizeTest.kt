package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PrizeTest {

    @Test
    fun `getPrize should return FIRST for 6 matches`() {
        assertThat(Prize.getPrize(6, false)).isEqualTo(Prize.FIRST)
        assertThat(Prize.getPrize(6, true)).isEqualTo(Prize.FIRST) // Bonus doesn't matter for 6 matches
    }

    @Test
    fun `getPrize should return SECOND_BONUS for 5 matches and bonus`() {
        assertThat(Prize.getPrize(5, true)).isEqualTo(Prize.SECOND_BONUS)
    }

    @Test
    fun `getPrize should return THIRD for 5 matches without bonus`() {
        assertThat(Prize.getPrize(5, false)).isEqualTo(Prize.THIRD)
    }

    @Test
    fun `getPrize should return FOURTH for 4 matches`() {
        assertThat(Prize.getPrize(4, false)).isEqualTo(Prize.FOURTH)
        assertThat(Prize.getPrize(4, true)).isEqualTo(Prize.FOURTH) // Bonus doesn't matter
    }

    @Test
    fun `getPrize should return FIFTH for 3 matches`() {
        assertThat(Prize.getPrize(3, false)).isEqualTo(Prize.FIFTH)
        assertThat(Prize.getPrize(3, true)).isEqualTo(Prize.FIFTH) // Bonus doesn't matter
    }

    @Test
    fun `getPrize should return NONE for less than 3 matches`() {
        assertThat(Prize.getPrize(2, false)).isEqualTo(Prize.NONE)
        assertThat(Prize.getPrize(2, true)).isEqualTo(Prize.NONE)
        assertThat(Prize.getPrize(1, false)).isEqualTo(Prize.NONE)
        assertThat(Prize.getPrize(0, false)).isEqualTo(Prize.NONE)
    }
}